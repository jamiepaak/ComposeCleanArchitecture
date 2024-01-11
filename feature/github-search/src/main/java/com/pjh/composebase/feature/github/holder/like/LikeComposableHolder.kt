package com.pjh.composebase.feature.github.holder.like

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.pjh.composebase.design.system.GitScaffold
import com.pjh.composebase.feature.github.holder.like.compose.LikeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LikeComposableHolder(
    bottomBar: @Composable () -> Unit,
    likeViewModel: LikeViewModel,
) {
    GitScaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "GitHubUserSearch")
                },
            )
        },
        bottomBar = bottomBar,
    ) {
        LikeScreen(likeViewModel = likeViewModel)
    }
}