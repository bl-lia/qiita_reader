package com.krsk.qiitareader.presentation.internal.di.module;

import com.krsk.qiitareader.domain.executor.PostExecutionThread;
import com.krsk.qiitareader.domain.executor.ThreadExecutor;
import com.krsk.qiitareader.domain.interactor.GetItemsUseCase;
import com.krsk.qiitareader.domain.interactor.UseCase;
import com.krsk.qiitareader.domain.model.entity.Item;
import com.krsk.qiitareader.domain.repository.ItemRepository;
import com.krsk.qiitareader.presentation.internal.di.PerFragment;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bl-lia on 2/1/16.
 */
@Module
public class ItemModule {

    @Provides @PerFragment @Named("getItems")
    UseCase<List<Item>> provideGetItems(ItemRepository itemRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetItemsUseCase(itemRepository, threadExecutor, postExecutionThread);
    }
}
