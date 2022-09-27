package com.app.tradesm8.views.activities.forgot

import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModelProvider
import com.app.tradesm8.MyApp
import com.app.tradesm8.R
import com.app.tradesm8.databinding.ActivityForgotBinding
import com.app.tradesm8.utilities.common.FailureListener
import com.app.tradesm8.utilities.common.customToast
import com.app.tradesm8.viewModels.ForgotViewModel
import com.app.tradesm8.views.activities.login.LoginActivity

class ForgotObserver(private val forgotActivity: ForgotActivity) : LifecycleObserver,
    FailureListener {

    private lateinit var forgotViewModel: ForgotViewModel

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated(){

        val binding : ActivityForgotBinding = DataBindingUtil.setContentView(forgotActivity, R.layout.activity_forgot)

        (forgotActivity.application as MyApp).myComponent.inject(forgotActivity)
        forgotViewModel = ViewModelProvider(forgotActivity,forgotActivity.factory).get(ForgotViewModel::class.java)
       // (forgotActivity.application as MyApp).myComponent.inject(forgotActivity)

        binding.viewModel = forgotViewModel
        forgotViewModel.failureListener = this

        forgotViewModel.response.observe(forgotActivity, {
            if (it.statusCode == 200){
                forgotActivity.startActivity(Intent(forgotActivity,LoginActivity::class.java))
                forgotActivity.customToast("Please Check your email for new Password")
            }
            else {
                forgotActivity.customToast("Something Went Wrong")
            }
        })

    }

    override fun onFailure(message: String) {
        forgotActivity.customToast(message)
    }
}