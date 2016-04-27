package com.krsk.qiitareader.presentation.internal.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.krsk.qiitareader.BuildConfig
import com.krsk.qiitareader.data.cache.ItemCache
import com.krsk.qiitareader.data.cache.ItemMemoryCache
import com.krsk.qiitareader.data.executor.JobExecutor
import com.krsk.qiitareader.data.repository.ItemDataRepository
import com.krsk.qiitareader.domain.executor.PostExecutionThread
import com.krsk.qiitareader.domain.executor.ThreadExecutor
import com.krsk.qiitareader.domain.repository.ItemRepository
import com.krsk.qiitareader.presentation.UIThread

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.RxJavaCallAdapterFactory

/**
 * Created by bl-lia on 2/1/16.
 */
@Module
class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okHttpClient).build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().addInterceptor(interceptor).addNetworkInterceptor(StethoInterceptor()).build()
    }

    @Provides
    @Singleton
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    internal fun provideItemRepository(itemDataRepository: ItemDataRepository): ItemRepository {
        return itemDataRepository
    }

    @Provides
    @Singleton
    internal fun provideItemCache(itemMemoryCache: ItemMemoryCache): ItemCache {
        return itemMemoryCache
    }
}
