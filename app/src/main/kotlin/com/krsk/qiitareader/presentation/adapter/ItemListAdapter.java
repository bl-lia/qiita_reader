package com.krsk.qiitareader.presentation.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.krsk.qiitareader.R;
import com.krsk.qiitareader.domain.model.entity.Item;
import com.krsk.qiitareader.presentation.adapter.viewholder.ItemViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by bl-lia on 2/2/16.
 */
public class ItemListAdapter extends RecyclerView.Adapter {

    private final List<Item> items = new ArrayList<>();
    private final PublishSubject<Item> itemPublishSubject = PublishSubject.create();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final View view = LayoutInflater.from(context).inflate(R.layout.list_row_item, parent, false);

        return ItemViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  ItemViewHolder) {
            final Item item = this.items.get(position);
            final ItemViewHolder viewHolder = (ItemViewHolder) holder;

            viewHolder.bind(item);
            viewHolder.getClickActionObservable().subscribe(itemPublishSubject);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Observable<Item> getItemClickObservable() {
        return itemPublishSubject;
    }

    public void resetList(List<Item> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }
}
