package com.krsk.qiitareader.data.repository;

import com.krsk.qiitareader.data.repository.datasource.item.ItemDataStoreFactory;
import com.krsk.qiitareader.domain.model.entity.Item;
import com.krsk.qiitareader.domain.repository.ItemRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by bl-lia on 2/1/16.
 */
public class ItemDataRepository implements ItemRepository {

    private final ItemDataStoreFactory itemDataStoreFactory;

    @Inject
    public ItemDataRepository(ItemDataStoreFactory itemDataStoreFactory) {
        this.itemDataStoreFactory = itemDataStoreFactory;
    }

    @Override
    public Observable<List<Item>> getItems() {
        return this.itemDataStoreFactory.create().getItems();
    }
}
