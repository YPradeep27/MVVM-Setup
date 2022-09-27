package com.app.tradesm8.utilities.dagger.modules

import com.app.tradesm8.utilities.common.Constants
import com.app.tradesm8.utilities.dagger.annotations.scopes.ApplicationScope
import com.app.tradesm8.utilities.network.RetrofitService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
class RetrofitModule {

    @Provides
    @ApplicationScope
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor
    {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { /*Timber.i(it) */})
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @ApplicationScope
    fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient
    {
        return OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(210, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(okhttpClient: OkHttpClient): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okhttpClient)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideRetrofitService(retrofit: Retrofit): RetrofitService
    {
        return retrofit.create(RetrofitService::class.java)
    }

}