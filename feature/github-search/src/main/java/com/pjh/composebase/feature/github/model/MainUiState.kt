package com.pjh.composebase.feature.github.model

import androidx.compose.runtime.Immutable
import com.pjh.composebase.feature.github.ViewType
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class MainUiState(
    val bottomItems: PersistentList<Bottom>,
) {

    @Immutable
    data class Bottom(
        val title: Int,
        val selected: Boolean,
        val icon: Int,
        val viewType: ViewType,
    )

    companion object {

        val Default = MainUiState(
            bottomItems = persistentListOf(),
        )
    }
}