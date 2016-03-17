package com.krsk.qiitareader.data.repository

import com.krsk.qiitareader.data.repository.datasource.item.ItemDataStoreFactory
import com.krsk.qiitareader.domain.model.entity.Item
import com.krsk.qiitareader.domain.repository.ItemRepository

import javax.inject.Inject

import rx.Observable
import javax.inject.Singleton

/**
 * Created by bl-lia on 2/1/16.
 */
@Singleton
class ItemDataRepository
@Inject
constructor(private val itemDataStoreFactory: ItemDataStoreFactory) : ItemRepository {

    override fun getItems(): Observable<List<Item>> {
        return this.itemDataStoreFactory.create().getItems()
    }
}
