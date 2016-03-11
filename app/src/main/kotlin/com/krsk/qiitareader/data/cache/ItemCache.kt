package com.krsk.qiitareader.data.cache

import com.krsk.qiitareader.domain.model.entity.Item

/**
 * Created by yuki_fn on 3/11/16.
 */
interface ItemCache {
    fun isCached(): Boolean
    fun resetCache(items: List<Item>)
    fun addCache(items: List<Item>)
    fun clearCache()
}