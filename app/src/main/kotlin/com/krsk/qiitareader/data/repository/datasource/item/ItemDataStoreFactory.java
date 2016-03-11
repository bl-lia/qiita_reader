package com.krsk.qiitareader.data.repository.datasource.item;

import com.krsk.qiitareader.data.cache.ItemCache;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;

/**
 * Created by bl-lia on 2/1/16.
 */
@Singleton
public class ItemDataStoreFactory {

    private final Retrofit retrofit;
    private final ItemCache itemCache;

    @Inject
    public ItemDataStoreFactory(Retrofit retrofit, ItemCache itemCache) {
        this.retrofit = retrofit;
        this.itemCache = itemCache;
    }

    public ItemDataStore create() {
        final ItemService itemService = this.retrofit.create(ItemService.class);
        return new ApiItemDataStore(itemService, itemCache);
    }
}
