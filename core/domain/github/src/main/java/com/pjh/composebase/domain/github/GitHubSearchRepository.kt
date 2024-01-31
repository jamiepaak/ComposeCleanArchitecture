package com.pjh.composebase.domain.github

import com.pjh.composebase.domain.github.model.GitHubSortType
import com.pjh.composebase.domain.github.model.GitHubUserEntity
import kotlinx.coroutines.flow.Flow

interface GitHubSearchRepository {

    fun flowLoadData(searchKeyword: String, perPage: Int): Flow<List<GitHubUserEntity>>

    fun sortList(gitHubSortType: GitHubSortType)

    fun flowLoadLikedData(): Flow<List<GitHubUserEntity>>

    /**
     * 좋아요 상태 변경
     */
    suspend fun likeUserInfo(item: GitHubUserEntity)

    suspend fun unlikeUserInfo(id: Int)

    fun clear()
}