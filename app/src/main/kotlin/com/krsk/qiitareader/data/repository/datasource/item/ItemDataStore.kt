package com.krsk.qiitareader.data.repository.datasource.item

import com.krsk.qiitareader.domain.model.entity.Item

import rx.Observable

/**
 * Created by bl-lia on 2/1/16.
 */
interface ItemDataStore {
    fun getItems(): Observable<List<Item>>
}
