package com.siloam.opd.di
import com.siloam.opd.data.repoimpl.GithubRepoImpl
import com.siloam.opd.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule{

    @Binds
    fun bindGithubRepository(githubRepoImpl: GithubRepoImpl): GithubRepository

}