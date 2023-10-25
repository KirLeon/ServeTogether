package com.codingub.hackathonproject.network

import com.codingub.hackathonproject.data.remote.AppApi
import com.codingub.hackathonproject.utils.Constants.Injection.IS_DEBUG
import com.codingub.hackathonproject.utils.Constants.Injection.RETROFIT_ENDPOINT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * [AppNetworking] allows to interact with network calls
 */
@Singleton
open class AppNetworking @Inject constructor(
    @Named(IS_DEBUG) val isDebugMode: Boolean,
    @Named(RETROFIT_ENDPOINT) private val endpoint: String,
    private val interceptor: AppInterceptor
) {

    private var retrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null

    private fun retrofit(): Retrofit {
        if(retrofit == null) retrofit = retrofitBuilder().build()
        return requireNotNull(retrofit)
    }

    @Synchronized
    open fun okHttpClient(): OkHttpClient {
        if (okHttpClient == null) {
            val builder: OkHttpClient.Builder = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    setLevel(
                        if (isDebugMode) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    )
                }).addInterceptor(interceptor)

            okHttpClient = builder.build()
        }
        return requireNotNull(okHttpClient)
    }

    private fun retrofitBuilder(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient())
    }

    fun provideAPI(): AppApi = retrofit().create(AppApi::class.java)


}