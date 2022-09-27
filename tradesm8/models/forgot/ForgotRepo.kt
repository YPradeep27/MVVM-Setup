package com.app.tradesm8.models.forgot

import androidx.lifecycle.MutableLiveData
import com.app.tradesm8.utilities.network.RetrofitService
import javax.inject.Inject

class ForgotRepo @Inject constructor(private val retrofitService: RetrofitService) {

    suspend fun userForgot(email : String) : ForgotPOJO {
        return retrofitService.forgotPassword(email)
    }
}