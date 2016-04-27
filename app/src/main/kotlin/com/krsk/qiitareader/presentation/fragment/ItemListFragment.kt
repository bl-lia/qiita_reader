package com.krsk.qiitareader.presentation.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.krsk.qiitareader.QRApplication
import com.krsk.qiitareader.R
import com.krsk.qiitareader.domain.model.entity.Item
import com.krsk.qiitareader.presentation.adapter.ItemListAdapter
import com.krsk.qiitareader.presentation.internal.di.component.DaggerItemListComponent
import com.krsk.qiitareader.presentation.internal.di.component.ItemListComponent
import com.krsk.qiitareader.presentation.internal.di.module.FragmentModule
import com.krsk.qiitareader.presentation.internal.di.module.ItemModule
import com.krsk.qiitareader.presentation.presenter.ItemListPresenter

import javax.inject.Inject

import butterknife.Bind
import butterknife.ButterKnife
import butterknife.bindView
import rx.functions.Action1
import timber.log.Timber

/**
 * Created by bl-lia on 2/1/16.
 */
class ItemListFragment : Fragment() {

    @Inject
    lateinit var itemListPresenter: ItemListPresenter

    val itemList: RecyclerView by bindView(R.id.item_list)

    private val component: ItemListComponent by lazy {
        DaggerItemListComponent.builder()
                                .applicationComponent((activity.application as QRApplication).component)
                                .fragmentModule(FragmentModule(this))
                                .itemModule(ItemModule())
                                .build()
    }

    private val adapter: ItemListAdapter by lazy { ItemListAdapter() }
    private val layoutManager: LinearLayoutManager by lazy { LinearLayoutManager(activity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_item, container, false)
        ButterKnife.bind(this, view)
        initView()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        itemList.layoutManager = this.layoutManager
        itemList.adapter = this.adapter
    }

    override fun onResume() {
        super.onResume()
        itemListPresenter.resume()
        itemListPresenter.listItems()
    }

    override fun onPause() {
        itemListPresenter.pause()
        super.onPause()
    }

    override fun onDestroy() {
        itemListPresenter.destroy()
        super.onDestroy()
    }

    fun resetList(items: List<Item>) {
        this.adapter.resetList(items)
    }

    private fun initView() {
        this.adapter.itemClickObservable.subscribe { itemListPresenter.navigateItemDetail(it) }
    }

    companion object {
        @JvmStatic
        fun newInstance(): ItemListFragment {
            return ItemListFragment()
        }
    }
}
