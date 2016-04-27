package com.krsk.qiitareader.presentation.internal.di.component

import com.krsk.qiitareader.domain.executor.PostExecutionThread
import com.krsk.qiitareader.domain.executor.ThreadExecutor
import com.krsk.qiitareader.domain.repository.ItemRepository
import com.krsk.qiitareader.presentation.internal.di.module.ApplicationModule

import javax.inject.Singleton

import dagger.Component
import dagger.Module

/**
 * Created by bl-lia on 2/1/16.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun threadExecutor(): ThreadExecutor
    fun postExecutionThread(): PostExecutionThread
    fun itemRepository(): ItemRepository
}
