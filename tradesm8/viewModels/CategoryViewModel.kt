package com.app.tradesm8.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.tradesm8.models.category.CategoryPOJO
import com.app.tradesm8.models.category.CategoryRepo
import com.app.tradesm8.utilities.common.coroutines.Coroutines
import retrofit2.Response
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val categoryRepo: CategoryRepo) : ViewModel() {

    var response : MutableLiveData<CategoryPOJO> = MutableLiveData()

    fun getCategory(userId : String , isVan : String){

        Coroutines.main {
            Log.i("Data", categoryRepo.getCategories(userId, isVan).toString())

            response.value = categoryRepo.getCategories(userId, isVan)

        }
    }
}