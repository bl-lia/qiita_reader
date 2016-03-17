package com.krsk.qiitareader.data.repository.datasource.item

import com.krsk.qiitareader.domain.model.entity.Item

import retrofit2.http.GET
import rx.Observable

/**
 * Created by bl-lia on 2/1/16.
 */
interface ItemService {
    @GET("/api/v2/items")
    fun items(): Observable<List<Item>>
}
