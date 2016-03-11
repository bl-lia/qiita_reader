package com.krsk.qiitareader.data.repository.datasource.item

import android.util.Log

import com.krsk.qiitareader.data.cache.ItemCache
import com.krsk.qiitareader.domain.model.entity.Item

import rx.Observable
import rx.functions.Action1
import rx.functions.Func1

/**
 * Created by bl-lia on 2/1/16.
 */
class ApiItemDataStore(private val itemService: ItemService,
                       private val itemCache: ItemCache) : ItemDataStore {

    override fun getItems(): Observable<List<Item>> {
        return this.itemService.items().doOnNext { itemCache.resetCache(it) }
    }
}
