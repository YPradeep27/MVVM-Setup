package com.app.tradesm8.models.welcome

import com.app.tradesm8.utilities.common.retrieveUser
import com.app.tradesm8.utilities.network.RetrofitService
import com.app.tradesm8.views.activities.welcome.WelcomeActivity
import javax.inject.Inject

class UserExistRepo @Inject constructor(private val retrofitService: RetrofitService, private val welcomeActivity: WelcomeActivity) {

    suspend fun userExist(userId : String) : UserExistPOJO {
        return retrofitService.userExist(userId)
    }

    fun retrieveUser(key : String ) = welcomeActivity.retrieveUser(key)
}