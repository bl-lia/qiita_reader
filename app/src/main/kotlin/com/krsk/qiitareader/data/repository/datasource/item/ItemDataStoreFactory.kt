package com.krsk.qiitareader.data.repository.datasource.item

import com.krsk.qiitareader.data.cache.ItemCache

import javax.inject.Inject
import javax.inject.Singleton

import retrofit2.Retrofit

/**
 * Created by bl-lia on 2/1/16.
 */
@Singleton
class ItemDataStoreFactory
@Inject
constructor(private val retrofit: Retrofit,
            private val itemCache: ItemCache) {

    fun create(): ItemDataStore {
        val itemService = retrofit.create(ItemService::class.java)
        return ApiItemDataStore(itemService, itemCache)
    }
}
