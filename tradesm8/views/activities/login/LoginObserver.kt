package com.app.tradesm8.views.activities.login

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.text.InputType
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModelProvider
import com.app.tradesm8.R
import com.app.tradesm8.databinding.ActivityLoginBinding
import com.app.tradesm8.models.login.LoginPOJO
import com.app.tradesm8.models.login.LoginRepo
import com.app.tradesm8.utilities.common.*
import com.app.tradesm8.utilities.common.Constants.SignUpUrl
import com.app.tradesm8.utilities.network.RetrofitService
import com.app.tradesm8.viewModels.LoginViewModel
import com.app.tradesm8.views.activities.forgot.ForgotActivity
import com.app.tradesm8.views.activities.welcome.WelcomeActivity

class LoginObserver(private val loginActivity: LoginActivity) : LifecycleObserver, LoginListener {

    lateinit var loginViewModel: LoginViewModel

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated() {
        initializations()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        sendFirebaseAnalytics(loginActivity.applicationContext,"Login", javaClass.name)
    }

    private fun initializations() {

        val factory = LoginViewModel(LoginRepo(RetrofitService(),loginActivity)).createFactory()

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(loginActivity, R.layout.activity_login)

        loginViewModel = ViewModelProvider(loginActivity, factory).get(LoginViewModel::class.java)
      //  (loginActivity.application as MyApp).myComponent.inject(loginActivity)
        loginViewModel.loginListener = this

        sendFirebaseAnalytics(loginActivity.applicationContext,"Login", javaClass.name)
        statusBar(loginActivity)

        binding.let {
            it.viewModel = loginViewModel
            it.edtxtEmail.setRawInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE)
            it.edtxtPassword.setRawInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE)
            it.forgotPassword.paintFlags = binding.forgotPassword.paintFlags or Paint.UNDERLINE_TEXT_FLAG

            it.edtxtPassword.setOnFocusChangeListener { v, hasFocus ->
                if (!hasFocus) {
                    if (v != null) {
                        hideKeyboard(v, loginActivity)
                    }
                }
            }

            it
        }


    }

    override fun onStarted() {
        loginActivity.startActivity(Intent(loginActivity, ForgotActivity::class.java))
    }

    override fun onSignup() {
        loginActivity.startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(SignUpUrl)))
    }

    override fun onSuccess(loginPOJO: LoginPOJO) {
        loginActivity.customToast("Login Successfully")
        loginActivity.startActivity(Intent(loginActivity, WelcomeActivity::class.java))
    }

    override fun onFailure(message: String) {
        loginActivity.customToast(message)
    }
}