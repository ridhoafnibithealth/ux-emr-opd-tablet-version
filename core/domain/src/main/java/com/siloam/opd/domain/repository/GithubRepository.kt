package com.siloam.opd.domain.repository

import kotlinx.coroutines.flow.Flow
import com.siloam.opd.domain.usecase.ProfileUseCase
import com.siloam.opd.domain.usecase.RepoListUseCase
import com.siloam.opd.entity.ProfileEntity
import com.siloam.opd.entity.RepoItemEntity
import com.siloam.opd.domain.utils.Result


interface GithubRepository {
    suspend fun fetchRepoList(params: RepoListUseCase.Params): Flow<Result<List<RepoItemEntity>>>
    suspend fun fetchProfile(params: ProfileUseCase.Params):Flow<Result<ProfileEntity>>
}