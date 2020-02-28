package com.versatile.github_search.domain.usecase

import com.versatile.github_search.domain.model.RepoItem
import com.versatile.github_search.domain.repository.RepoRepository
import com.versatile.github_search.domain.usecase.base.SingleUseCase
import io.reactivex.Single

class GetRepoUseCase(private val repoRepository: RepoRepository) : SingleUseCase<List<RepoItem>, String>() {


    override fun buildUseCaseSingle(params: String): Single<List<RepoItem>> {
        return repoRepository.getRepo(params)
    }

}