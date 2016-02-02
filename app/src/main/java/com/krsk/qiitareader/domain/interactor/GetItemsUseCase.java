package com.krsk.qiitareader.domain.interactor;

import com.krsk.qiitareader.domain.executor.PostExecutionThread;
import com.krsk.qiitareader.domain.executor.ThreadExecutor;
import com.krsk.qiitareader.domain.model.entity.Item;
import com.krsk.qiitareader.domain.repository.ItemRepository;

import java.util.List;

import rx.Observable;

/**
 * Created by bl-lia on 2/1/16.
 */
public class GetItemsUseCase extends UseCase<List<Item>> {

    private final ItemRepository itemRepository;

    public GetItemsUseCase(ItemRepository itemRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.itemRepository = itemRepository;
    }

    @Override
    protected Observable<List<Item>> buildUseCaseObservable() {
        return this.itemRepository.getItems();
    }
}
