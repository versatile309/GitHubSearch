package com.versatile.github_search.data.data_source.remote

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    /**
     * GitHubAPI URL 선언
     */
    private const val BASE_URL = "https://api.github.com/"

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideAPI(retrofit: Retrofit): GitHubAPI {
        return retrofit.create(GitHubAPI::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}