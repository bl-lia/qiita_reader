package com.krsk.qiitareader.domain.model.entity

import android.net.Uri

import com.google.gson.annotations.SerializedName

/**
 * Created by bl-lia on 2/2/16.
 */
data class User(val id: String,
                @SerializedName("profile_image_url") val profileImageUri: String)
