package com.pjh.composebase.data.github.di

import com.pjh.composebase.data.github.GitHubSearchRepositoryImpl
import com.pjh.composebase.domain.github.GitHubSearchRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class GitHubSearchModule {

    @Binds
    @Reusable
    abstract fun bindGitHubSearchRepository(
        gitHubSearchRepository: GitHubSearchRepositoryImpl,
    ): GitHubSearchRepository
}