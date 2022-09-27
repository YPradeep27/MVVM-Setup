package com.app.tradesm8.views.activities.login

import com.app.tradesm8.models.login.LoginPOJO

interface LoginListener {

    fun onStarted()
    fun onSignup()
    fun onSuccess(loginPOJO: LoginPOJO)
    fun onFailure(message : String)
}