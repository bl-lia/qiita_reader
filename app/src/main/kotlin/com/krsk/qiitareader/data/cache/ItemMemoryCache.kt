package com.krsk.qiitareader.data.cache

import com.krsk.qiitareader.domain.model.entity.Item
import java.util.*
import javax.inject.Inject

/**
 * Created by yuki_fn on 3/11/16.
 */
class ItemMemoryCache
@Inject constructor(): ItemCache{

    private val itemCache = ArrayList<Item>()

    override fun isCached(): Boolean = itemCache.size > 0

    override fun resetCache(items: List<Item>) {
        itemCache.clear()
        itemCache.addAll(items)
    }

    override fun addCache(items: List<Item>) {
        itemCache.addAll(items)
    }

    override fun clearCache() {
        itemCache.clear();
    }
}