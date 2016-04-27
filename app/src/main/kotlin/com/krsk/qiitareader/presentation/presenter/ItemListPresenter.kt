package com.krsk.qiitareader.presentation.presenter

import android.app.Fragment
import android.net.Uri
import android.support.customtabs.CustomTabsIntent

import com.krsk.qiitareader.domain.interactor.UseCase
import com.krsk.qiitareader.domain.model.entity.Item
import com.krsk.qiitareader.presentation.fragment.ItemListFragment
import com.krsk.qiitareader.presentation.internal.di.PerFragment

import java.util.ArrayList

import javax.inject.Inject
import javax.inject.Named

/**
 * Created by bl-lia on 2/2/16.
 */
@PerFragment
class ItemListPresenter
@Inject
constructor(fragment: Fragment,
            @Named("getItems") private val getItemsUseCase: UseCase<List<Item>>) : Presenter {

    private val fragment: ItemListFragment

    init {
        this.fragment = fragment as ItemListFragment
    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {

    }

    fun listItems() {
        this.getItemsUseCase.execute(object : UseCase.UseCaseSubscriber<List<Item>>() {

            private val items = ArrayList<Item>()

            override fun onCompleted() {
                fragment.resetList(this.items)
            }

            override fun onNext(items: List<Item>) {
                this.items.addAll(items)
            }
        })
    }

    fun navigateItemDetail(item: Item) {
        val intent = CustomTabsIntent.Builder().setShowTitle(true).build()
        intent.launchUrl(fragment.activity, Uri.parse(item.url))
    }

}
