package com.krsk.qiitareader.data.repository.datasource.item;

import com.krsk.qiitareader.domain.model.entity.Item;

import java.util.List;

import rx.Observable;

/**
 * Created by bl-lia on 2/1/16.
 */
public interface ItemDataStore {

    Observable<List<Item>> getItems();
}
