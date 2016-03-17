package com.krsk.qiitareader.domain.repository

import com.krsk.qiitareader.domain.model.entity.Item

import rx.Observable

/**
 * Created by bl-lia on 2/1/16.
 */
interface ItemRepository {

    fun getItems(): Observable<List<Item>>
}
