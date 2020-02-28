package com.versatile.github_search.presentation.main

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.versatile.github_search.data.data_source.remote.GitHubAPI
import com.versatile.github_search.data.repository.RepoRepositoryImpl
import com.versatile.github_search.domain.model.RepoItem
import com.versatile.github_search.domain.usecase.GetRepoUseCase
import com.versatile.github_search.presentation.base.BaseViewModel
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    @Inject
    lateinit var gitHubAPI: GitHubAPI

    val repoListAdapter = RepoListAdapter()

    var keyword = ObservableField<String>()

    object DataBindingAdapter {

        @BindingAdapter("app:adapter")
        @JvmStatic
        fun setAdapter(recyclerView: RecyclerView, adapter: RepoListAdapter){
            recyclerView.adapter = adapter
        }

    }



     fun getRepos(){
         keyword.get()?.let {
             Log.e("keyword", it)
             progressVisibility.set(View.VISIBLE)
             GetRepoUseCase(RepoRepositoryImpl(gitHubAPI))
                 .get(it)
                 .doOnSuccess { progressVisibility.set(View.GONE) }
                 .doOnError { progressVisibility.set(View.GONE) }
                 .subscribe(
                     { list ->
                         Log.e("test", list.size.toString())
                        updateList(list)
                     },{ throwable -> throwable.message?.let { Log.e("test", "error") }})
     //            .dispose()
         }


    }

    fun updateList(repoList : List<RepoItem>){
        repoListAdapter.updateRepos(repoList)
        repoListAdapter.notifyDataSetChanged()
    }

}