package com.krsk.qiitareader.presentation.internal.di.component

import com.krsk.qiitareader.presentation.fragment.ItemListFragment
import com.krsk.qiitareader.presentation.internal.di.PerActivity
import com.krsk.qiitareader.presentation.internal.di.PerFragment
import com.krsk.qiitareader.presentation.internal.di.module.FragmentModule
import com.krsk.qiitareader.presentation.internal.di.module.ItemModule

import dagger.Component

/**
 * Created by bl-lia on 2/1/16.
 */
@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class, ItemModule::class))
interface ItemListComponent {
    fun inject(fragment: ItemListFragment)
}
