package com.app.tradesm8.models.login

import com.app.tradesm8.utilities.common.saveUser
import com.app.tradesm8.utilities.network.RetrofitService
import com.app.tradesm8.views.activities.login.LoginActivity
import retrofit2.Response
import javax.inject.Inject

class LoginRepo @Inject constructor(private val retrofitService: RetrofitService, private val loginActivity: LoginActivity) {

    suspend fun userLogin(email : String, password : String, deviceId : String, deviceStatus : String) : Response<LoginPOJO>{
       return retrofitService.userLogin(email, password, deviceId, deviceStatus)
    }

    fun saveUser(key : String , value : String) = loginActivity.saveUser(key,value)
}