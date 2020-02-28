package com.versatile.github_search.domain.repository

import com.versatile.github_search.domain.model.RepoItem
import io.reactivex.Single

interface RepoRepository {

    fun getRepo(param : String) : Single<List<RepoItem>>
}