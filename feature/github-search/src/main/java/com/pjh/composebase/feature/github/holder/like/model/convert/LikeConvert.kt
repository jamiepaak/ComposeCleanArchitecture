package com.pjh.composebase.feature.github.holder.like.model.convert

import com.pjh.composebase.domain.github.model.GitHubUserEntity
import com.pjh.composebase.feature.github.holder.like.model.LikeUiState
import kotlinx.collections.immutable.toPersistentList


internal fun List<GitHubUserEntity>.convert(): LikeUiState =
    LikeUiState.UserItems(
        items = map { item ->
            LikeUiState.UserItems.Info(
                id = item.id,
                login = item.login,
                avatarUrl = item.avatarUrl,
                score = item.score,
                isLike = item.isLike,
            )
        }.toSet().toPersistentList()
    )