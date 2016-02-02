package com.krsk.qiitareader.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krsk.qiitareader.QRApplication;
import com.krsk.qiitareader.R;
import com.krsk.qiitareader.domain.model.entity.Item;
import com.krsk.qiitareader.presentation.adapter.ItemListAdapter;
import com.krsk.qiitareader.presentation.internal.di.component.DaggerItemListComponent;
import com.krsk.qiitareader.presentation.internal.di.component.ItemListComponent;
import com.krsk.qiitareader.presentation.internal.di.module.FragmentModule;
import com.krsk.qiitareader.presentation.internal.di.module.ItemModule;
import com.krsk.qiitareader.presentation.presenter.ItemListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by bl-lia on 2/1/16.
 */
public class ItemListFragment extends Fragment {

    @Inject ItemListPresenter itemListPresenter;
    @Bind(R.id.item_list) RecyclerView itemList;

    private ItemListComponent component;
    private ItemListAdapter adapter;
    private LinearLayoutManager layoutManager;

    public static ItemListFragment newInstance() {
        return new ItemListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.component().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list_item, container, false);
        ButterKnife.bind(this, view);
        initView();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        itemListPresenter.resume();
        itemListPresenter.listItems();
    }

    @Override
    public void onPause() {
        itemListPresenter.pause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        itemListPresenter.destroy();
        super.onDestroy();
    }

    public void resetList(List<Item> items) {
        this.adapter.resetList(items);
    }

    private ItemListComponent component() {
        if (component == null) {
            component = DaggerItemListComponent.builder()
                                            .applicationComponent(((QRApplication)getActivity().getApplication()).getComponent())
                                            .fragmentModule(new FragmentModule(this))
                                            .itemModule(new ItemModule())
                                            .build();
        }

        return component;
    }

    private void initView() {
        this.layoutManager = new LinearLayoutManager(getActivity());
        this.itemList.setLayoutManager(this.layoutManager);
        this.adapter = new ItemListAdapter();
        this.itemList.setAdapter(this.adapter);
        this.adapter.getItemClickObservable().subscribe(new Action1<Item>() {
            @Override
            public void call(Item item) {
                itemListPresenter.navigateItemDetail(item);
            }
        });
    }
}
