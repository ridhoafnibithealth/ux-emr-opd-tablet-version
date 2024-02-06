package com.siloam.opd.domain.usecase

import com.siloam.opd.domain.repository.GithubRepository
import com.siloam.opd.domain.utils.ApiUseCaseParams
import com.siloam.opd.domain.utils.Result
import com.siloam.opd.entity.RepoItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoListUseCase @Inject constructor(
    private val repository: GithubRepository
):ApiUseCaseParams<RepoListUseCase.Params,List<RepoItemEntity>>{
    override suspend fun execute(params: Params): Flow<Result<List<RepoItemEntity>>> {
        return repository.fetchRepoList(params)
    }
    data class Params(val userName:String)
}