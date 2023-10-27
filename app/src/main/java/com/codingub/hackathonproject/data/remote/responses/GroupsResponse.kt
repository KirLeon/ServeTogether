package com.codingub.hackathonproject.data.remote.responses

data class GetGroupsSearchResponse(
    val groups: List<GroupsSearchInfo>
)

data class GroupsSearchInfo(
    val groupName: String,
    val activeAnnQuantity: Long,
    val pendingAnnQuantity: Long
)

