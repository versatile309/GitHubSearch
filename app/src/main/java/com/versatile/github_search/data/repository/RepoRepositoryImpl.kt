package com.versatile.github_search.data.repository

import com.versatile.github_search.data.data_source.remote.GitHubAPI
import com.versatile.github_search.domain.model.RepoItem
import com.versatile.github_search.domain.repository.RepoRepository
import io.reactivex.Single

class RepoRepositoryImpl(private val remoteDataSource : GitHubAPI) : RepoRepository{

    override fun getRepo(param: String): Single<List<RepoItem>> {
        return remoteDataSource.getRepo(param).map { result -> result.repoList.map { RepoItem((it.name)) } }
    }
}