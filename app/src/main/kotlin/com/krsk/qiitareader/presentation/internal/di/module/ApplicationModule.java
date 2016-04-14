package com.krsk.qiitareader.presentation.internal.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.krsk.qiitareader.BuildConfig;
import com.krsk.qiitareader.data.cache.ItemCache;
import com.krsk.qiitareader.data.cache.ItemMemoryCache;
import com.krsk.qiitareader.data.executor.JobExecutor;
import com.krsk.qiitareader.data.repository.ItemDataRepository;
import com.krsk.qiitareader.domain.executor.PostExecutionThread;
import com.krsk.qiitareader.domain.executor.ThreadExecutor;
import com.krsk.qiitareader.domain.repository.ItemRepository;
import com.krsk.qiitareader.presentation.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by bl-lia on 2/1/16.
 */
@Module
public class ApplicationModule {

    @Provides @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                        .baseUrl(BuildConfig.API_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
    }

    @Provides @Singleton
    OkHttpClient provideOkHttpClient() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                                .addInterceptor(interceptor)
                                .addNetworkInterceptor(new StethoInterceptor())
                                .build();
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    ItemRepository provideItemRepository(ItemDataRepository itemDataRepository) {
        return itemDataRepository;
    }

    @Provides @Singleton
    ItemCache provideItemCache(ItemMemoryCache itemMemoryCache) {
        return itemMemoryCache;
    }
}
