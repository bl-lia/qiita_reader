package com.krsk.qiitareader.presentation.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.krsk.qiitareader.R
import com.krsk.qiitareader.domain.model.entity.Item
import com.squareup.picasso.Picasso

import butterknife.Bind
import butterknife.ButterKnife
import butterknife.bindView
import rx.Observable
import rx.Subscriber

/**
 * Created by bl-lia on 3/17/16.
 */
class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView by bindView(R.id.item_title)
    val userIcon: ImageView by bindView(R.id.item_user_image)

    private var item: Item? = null

    val clickActionObservable = Observable.create(rx.Observable.OnSubscribe<com.krsk.qiitareader.domain.model.entity.Item> { subscriber ->
        itemView.setOnClickListener {
            if (item != null) {
                subscriber.onNext(item)
            }
        }
    })

    fun bind(item: Item) {
        this.item = item

        this.title.text = item.title

        if (!TextUtils.isEmpty(item.user.profileImageUri)) {
            Picasso.with(itemView.context).load(item.user.profileImageUri).into(userIcon)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(parent: View): ItemViewHolder {
            return ItemViewHolder(parent)
        }
    }

}
