package com.siloam.opd.data.repoimpl

import com.siloam.opd.data.apiservice.ApiService
import com.siloam.opd.data.mapper.ProfileMapper
import com.siloam.opd.data.mapper.RepoListItemMapper
import com.siloam.opd.data.utils.NetworkBoundResource
import com.siloam.opd.data.utils.mapFromApiResponse
import com.siloam.opd.domain.repository.GithubRepository
import com.siloam.opd.domain.usecase.ProfileUseCase
import com.siloam.opd.domain.usecase.RepoListUseCase
import com.siloam.opd.entity.ProfileEntity
import com.siloam.opd.entity.RepoItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.siloam.opd.domain.utils.Result
class GithubRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val networkBoundResources: NetworkBoundResource,
    private val repositoryListItemMapper: RepoListItemMapper,
    private val profileMapper: ProfileMapper
):GithubRepository{

    override suspend fun fetchRepoList(params: RepoListUseCase.Params): Flow<Result<List<RepoItemEntity>>> {
        return mapFromApiResponse(
            result = networkBoundResources.downloadData {
                apiService.fetchRepoList(params.userName)
            },repositoryListItemMapper
        )
    }

    override suspend fun fetchProfile(params: ProfileUseCase.Params): Flow<Result<ProfileEntity>> {
        return mapFromApiResponse(
            result = networkBoundResources.downloadData {
                apiService.fetchProfile(params.userName)
            },profileMapper
        )
    }

}