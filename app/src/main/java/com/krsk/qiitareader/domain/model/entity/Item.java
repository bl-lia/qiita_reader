package com.krsk.qiitareader.domain.model.entity;

/**
 * Created by bl-lia on 2/1/16.
 */
public class Item {

    public final String id;
    public final String title;
    public final String url;
    public final User user;

    public static Item create(String id, String title, String url, User user) {
        return new Item(id, title, url, user);
    }

    protected Item(String id, String title, String url, User user) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.user = user;
    }
}
