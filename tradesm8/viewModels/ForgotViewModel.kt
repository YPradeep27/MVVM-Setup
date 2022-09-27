package com.app.tradesm8.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.tradesm8.models.forgot.ForgotPOJO
import com.app.tradesm8.models.forgot.ForgotRepo
import com.app.tradesm8.utilities.common.coroutines.Coroutines
import com.app.tradesm8.utilities.common.FailureListener
import javax.inject.Inject

class ForgotViewModel @Inject constructor(private val forgotRepo: ForgotRepo) : ViewModel() {

    var email : String? = null
    var failureListener : FailureListener? = null
    var response : MutableLiveData<ForgotPOJO> = MutableLiveData()

    fun onForgotPasswordButton(view : View){

        if (email.isNullOrEmpty()){
            failureListener?.onFailure("Please Enter Email Address")
        }
        else {
            Coroutines.main {
               response.value  = forgotRepo.userForgot(email!!)
            }
        }
    }
}