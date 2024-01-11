package com.pjh.composebase.data.github.di

import com.pjh.composebase.data.github.GitHubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class GitHubApiModule {

    @Provides
    fun provideGitHubApi(
        retrofit: Retrofit,
    ): GitHubApi =
        retrofit.create(GitHubApi::class.java)
}