package com.krsk.qiitareader.presentation.presenter;

import android.app.Fragment;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;

import com.krsk.qiitareader.domain.interactor.UseCase;
import com.krsk.qiitareader.domain.model.entity.Item;
import com.krsk.qiitareader.presentation.fragment.ItemListFragment;
import com.krsk.qiitareader.presentation.internal.di.PerFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by bl-lia on 2/2/16.
 */
@PerFragment
public class ItemListPresenter implements Presenter {

    private final ItemListFragment fragment;
    private final UseCase<List<Item>> getItemsUseCase;

    @Inject
    public ItemListPresenter(Fragment fragment,
                             @Named("getItems") UseCase<List<Item>> getItemsUseCase) {
        this.fragment = (ItemListFragment) fragment;
        this.getItemsUseCase = getItemsUseCase;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void listItems() {
        this.getItemsUseCase.execute(new UseCase.UseCaseSubscriber<List<Item>>() {

            private List<Item> items = new ArrayList<>();

            @Override
            public void onCompleted() {
                fragment.resetList(this.items);
            }

            @Override
            public void onNext(List<Item> items) {
                this.items.addAll(items);
            }
        });
    }

    public void navigateItemDetail(Item item) {
        final CustomTabsIntent intent = new CustomTabsIntent.Builder()
                                                            .setShowTitle(true)
                                                            .build();
        intent.launchUrl(fragment.getActivity(), Uri.parse(item.url));
    }

}
