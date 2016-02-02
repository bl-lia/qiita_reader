package com.krsk.qiitareader.presentation.internal.di.component;

import com.krsk.qiitareader.domain.executor.PostExecutionThread;
import com.krsk.qiitareader.domain.executor.ThreadExecutor;
import com.krsk.qiitareader.domain.repository.ItemRepository;
import com.krsk.qiitareader.presentation.internal.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by bl-lia on 2/1/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    ItemRepository itemRepository();
}
