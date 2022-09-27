package com.app.tradesm8.models.category

import android.content.Context
import android.util.Log
import com.app.tradesm8.utilities.common.retrieveUser2
import com.app.tradesm8.utilities.network.RetrofitService
import com.app.tradesm8.views.fragments.category.CategoryFragment
import retrofit2.Response
import javax.inject.Inject

class CategoryRepo @Inject constructor(private val retrofitService: RetrofitService, private val categoryFragment: CategoryFragment) {

    suspend fun getCategories(userId : String , isVan : String) : CategoryPOJO {
        return retrofitService.getCategories(userId,isVan)
    }

    fun retrieveUser(context: Context ,key : String ) = retrieveUser2(context,key)
}