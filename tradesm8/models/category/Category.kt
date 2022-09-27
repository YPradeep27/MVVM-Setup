package com.app.tradesm8.models.category

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("cat-id") val catId: String,
    @SerializedName("cat-image") val catImage: String,
    @SerializedName("cat-name") val catName: String,
    @SerializedName("fillter") val filter: List<Any>,
    @SerializedName("status") val status: Int
)