package com.krsk.qiitareader.domain.interactor

import com.krsk.qiitareader.domain.executor.PostExecutionThread
import com.krsk.qiitareader.domain.executor.ThreadExecutor
import com.krsk.qiitareader.domain.model.entity.Item
import com.krsk.qiitareader.domain.repository.ItemRepository

import rx.Observable

/**
 * Created by bl-lia on 2/1/16.
 */
class GetItemsUseCase(private val itemRepository: ItemRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : UseCase<List<Item>>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(): Observable<List<Item>> {
        return this.itemRepository.getItems()
    }
}
