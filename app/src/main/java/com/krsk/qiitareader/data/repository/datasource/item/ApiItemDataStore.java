package com.krsk.qiitareader.data.repository.datasource.item;

import android.util.Log;

import com.krsk.qiitareader.domain.model.entity.Item;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by bl-lia on 2/1/16.
 */
public class ApiItemDataStore implements ItemDataStore {

    private final ItemService itemService;

    public ApiItemDataStore(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public Observable<List<Item>> getItems() {
        return this.itemService.items();
    }
}
