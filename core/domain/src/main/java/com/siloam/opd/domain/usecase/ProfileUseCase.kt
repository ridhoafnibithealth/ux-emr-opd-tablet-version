package com.siloam.opd.domain.usecase

import com.siloam.opd.domain.repository.GithubRepository
import com.siloam.opd.domain.utils.ApiUseCaseParams
import com.siloam.opd.domain.utils.Result
import com.siloam.opd.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val repository: GithubRepository
):ApiUseCaseParams<ProfileUseCase.Params, ProfileEntity>{
    data class Params(val userName:String)
    override suspend fun execute(params: Params): Flow<Result<ProfileEntity>> {
        return repository.fetchProfile(params)
    }
}