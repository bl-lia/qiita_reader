package com.krsk.qiitareader.domain.model.entity;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bl-lia on 2/2/16.
 */
public class User {

    public final String id;
    @SerializedName("profile_image_url")
    public final String profileImageUri;

    public static User create(String id, String profileImageUri) {
        return new User(id, profileImageUri);
    }

    protected User(String id, String profileImageUri) {
        this.id = id;
        this.profileImageUri = profileImageUri;
    }
}
