import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompilerAnnotation = "androidx.room:room-compiler:${Versions.room}"
    const val roomTest = "androidx.room:room-testing:${Versions.room}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val viewModelLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.viewModel}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glideCompose = "com.github.bumptech.glide:compose:${Versions.glideCompose}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val shimmerEffect = "androidx.core:core-splashscreen:${Versions.shimmerEffect}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}


fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    annotationProcessor(Dependencies.roomCompilerAnnotation)
    kapt(Dependencies.roomCompiler)
    testImplementation(Dependencies.roomTest)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    debugImplementation(Dependencies.composeUiToolingPreview)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.viewModel() {
    implementation(Dependencies.viewModel)
    implementation(Dependencies.viewModelLivedata)
}

fun DependencyHandler.coroutines() {
    implementation(Dependencies.coroutines)
    implementation(Dependencies.coroutinesCore)
    testImplementation(Dependencies.coroutinesTest)
}

fun DependencyHandler.recyclerView() {
    implementation(Dependencies.recyclerView)
}

fun DependencyHandler.gson(){
    implementation(Dependencies.gson)
}

fun DependencyHandler.shimmerEffect(){
    implementation(Dependencies.shimmerEffect)
}

fun DependencyHandler.glide(){
    implementation(Dependencies.glide)
    implementation(Dependencies.glideCompose)
    annotationProcessor(Dependencies.glideCompiler)
}

fun DependencyHandler.timber(){
    implementation(Dependencies.timber)
}

//пример подключения модуля к другому модулю
//fun DependencyHandler.booksUi() {
//    implementation(project(":books-ui"))
//}
