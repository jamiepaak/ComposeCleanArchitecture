package com.pjh.composebase.database.github.di

import android.content.Context
import com.pjh.composebase.database.github.GitHubDatabase
import com.pjh.composebase.database.github.api.GitHubUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object GitHubLocalDatabaseModule {

    @Singleton
    @Provides
    fun provideGitHubDatabase(
        @ApplicationContext context: Context
    ): GitHubDatabase {
        return GitHubDatabase.getInstance(context)
    }

    @Provides
    fun provideGitHubUserDao(gitHubDatabase: GitHubDatabase): GitHubUserDao {
        return gitHubDatabase.gitHubUserDao()
    }
}