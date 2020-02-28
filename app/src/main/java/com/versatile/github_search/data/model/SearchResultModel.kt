package com.versatile.github_search.data.model

import com.google.gson.annotations.SerializedName

class SearchResultModel(@SerializedName("total_count") val count : Int,
                        @SerializedName("items") val repoList : List<RepoDataModel>) {
}