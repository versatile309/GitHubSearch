package com.versatile.github_search.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.versatile.github_search.R
import com.versatile.github_search.databinding.ItemRepoListBinding
import com.versatile.github_search.domain.model.RepoItem

class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    private val repoList = ObservableArrayList<RepoItem>()

    fun updateRepos(repoList : List<RepoItem>){
        this.repoList.clear()
        this.repoList.addAll(repoList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_repo_list,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            bind(repoList[position])
            itemView.tag = repoList[position]
        }
    }

    inner class ViewHolder(private val binding : ItemRepoListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : RepoItem){
            binding.apply {
                repo = item
            }
        }
    }
}