package com.versatile.github_search.data.data_source.remote

import com.versatile.github_search.data.model.SearchResultModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * retrofit2 API를 선언하는 interface. 용도에 맞춰 구현할 것
 */
interface GitHubAPI {

    @GET("search/repositories")
    fun getRepo(
        @Query("q") query : String
    ) : Single<SearchResultModel>

}