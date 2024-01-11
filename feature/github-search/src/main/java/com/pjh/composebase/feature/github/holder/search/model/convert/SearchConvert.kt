package com.pjh.composebase.feature.github.holder.search.model.convert

import com.pjh.composebase.domain.github.model.GitHubUserEntity
import com.pjh.composebase.feature.github.holder.search.model.SearchUiState
import kotlinx.collections.immutable.toPersistentList

internal fun List<GitHubUserEntity>.convert(
    prevItem: SearchUiState,
): SearchUiState =
    prevItem.copy(
        uiState = SearchUiState.UiState.UserItems(
            items = map { item ->
                SearchUiState.UiState.UserItems.Info(
                    id = item.id,
                    login = item.login,
                    avatarUrl = item.avatarUrl,
                    score = item.score,
                    isLike = item.isLike,
                )
            }.toSet().toPersistentList()
        )
    )