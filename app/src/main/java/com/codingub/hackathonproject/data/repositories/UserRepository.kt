package com.codingub.hackathonproject.data.repositories

import com.codingub.hackathonproject.data.local.UserConfig
import com.codingub.hackathonproject.data.remote.AppApi
import com.codingub.hackathonproject.data.remote.responses.GroupsSearchInfo
import com.codingub.hackathonproject.network.ServerResponse
import retrofit2.HttpException
import javax.inject.Inject

interface UserRepository {

    suspend fun leaveGroup(groupName: String) : ServerResponse<Unit>
    suspend fun joinGroup(groupName: String) : ServerResponse<Unit>
    suspend fun getGroupsSearch(groupName: String) : ServerResponse<List<GroupsSearchInfo>>
}

class UserRepositoryImpl @Inject constructor(
    private val api: AppApi
) : UserRepository {

    override suspend fun leaveGroup(groupName: String): ServerResponse<Unit> {
        return try{
            api.leaveGroup(groupName, token = UserConfig.getToken())
            ServerResponse.OK(Unit)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                ServerResponse.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404) {
                ServerResponse.NotFound()
            } else if (e.code() == 401) {
                ServerResponse.Unauthorized()
            } else {
                ServerResponse.UnknownError()
            }
        } catch (e: Exception) {
            ServerResponse.UnknownError()
        }
    }

    override suspend fun joinGroup(groupName: String): ServerResponse<Unit> {
        return try{
            api.joinGroup(groupName, token = UserConfig.getToken())
            ServerResponse.OK(Unit)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                ServerResponse.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404) {
                ServerResponse.NotFound()
            } else if (e.code() == 401) {
                ServerResponse.Unauthorized()
            } else {
                ServerResponse.UnknownError()
            }
        } catch (e: Exception) {
            ServerResponse.UnknownError()
        }    }

    // search
    override suspend fun getGroupsSearch(groupName: String): ServerResponse<List<GroupsSearchInfo>> {
        return try{
            val result = api.getGroupsSearch(groupName, token = UserConfig.getToken())
            ServerResponse.OK(result.groups)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                ServerResponse.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404) {
                ServerResponse.NotFound()
            } else if (e.code() == 401) {
                ServerResponse.Unauthorized()
            } else {
                ServerResponse.UnknownError()
            }
        } catch (e: Exception) {
            ServerResponse.UnknownError()
        }    }
}