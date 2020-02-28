package com.versatile.github_search.presentation.base

import android.view.View
import androidx.databinding.ObservableField
import com.versatile.github_search.data.data_source.remote.NetworkModule
import com.versatile.github_search.presentation.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

abstract class BaseViewModel {

    var progressVisibility = ObservableField<Int>()

    init {
        inject()
        progressVisibility.set(View.GONE)
    }

    private fun inject() {
        when(this){
            is MainViewModel -> {
                DaggerBaseViewModel_NetworkComponent.builder()
                    .networkModule(NetworkModule)
                    .build()
                    .inject(this)
            }
        }
    }

    @Singleton
    @Component(modules = [NetworkModule::class])
    interface NetworkComponent {

        fun inject(mainViewModel: MainViewModel)

        @Component.Builder
        interface Builder {
            fun build() : NetworkComponent

            fun networkModule(networkModule : NetworkModule) : Builder
        }
    }
}