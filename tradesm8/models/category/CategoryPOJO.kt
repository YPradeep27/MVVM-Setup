package com.app.tradesm8.models.category

import com.google.gson.annotations.SerializedName

data class CategoryPOJO(
    @SerializedName("Category") val category: List<Category>,
    @SerializedName("numberofawating") val numberOfAwaiting: Int,
    val statusCode: Int
)