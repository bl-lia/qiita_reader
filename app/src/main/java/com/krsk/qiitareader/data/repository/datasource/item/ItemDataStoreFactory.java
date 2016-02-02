package com.krsk.qiitareader.data.repository.datasource.item;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;

/**
 * Created by bl-lia on 2/1/16.
 */
@Singleton
public class ItemDataStoreFactory {

    private final Retrofit retrofit;

    @Inject
    public ItemDataStoreFactory(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public ItemDataStore create() {
        final ItemService itemService = this.retrofit.create(ItemService.class);
        return new ApiItemDataStore(itemService);
    }
}
