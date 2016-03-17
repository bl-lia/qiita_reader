package com.krsk.qiitareader.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.krsk.qiitareader.R
import com.krsk.qiitareader.domain.model.entity.Item
import com.krsk.qiitareader.presentation.adapter.viewholder.ItemViewHolder
import com.squareup.picasso.Picasso

import java.util.ArrayList

import butterknife.Bind
import butterknife.ButterKnife
import rx.Observable
import rx.Subscriber
import rx.subjects.PublishSubject

/**
 * Created by bl-lia on 2/2/16.
 */
class ItemListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<Item>()
    private val itemPublishSubject = PublishSubject.create<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_row_item, parent, false)

        return ItemViewHolder.newInstance(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val item = this.items[position]

            holder.bind(item)
            holder.clickActionObservable.subscribe(itemPublishSubject)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    val itemClickObservable: Observable<Item>
        get() = itemPublishSubject

    fun resetList(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}
