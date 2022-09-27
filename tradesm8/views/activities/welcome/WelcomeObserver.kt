package com.app.tradesm8.views.activities.welcome

import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.app.tradesm8.R
import com.app.tradesm8.databinding.ActivityWelcomeBinding
import com.app.tradesm8.models.welcome.UserExistRepo
import com.app.tradesm8.utilities.common.*
import com.app.tradesm8.utilities.network.RetrofitService
import com.app.tradesm8.viewModels.WelcomeViewModel
import com.app.tradesm8.views.activities.home.HomeActivity

class WelcomeObserver(private val welcomeActivity: WelcomeActivity) : LifecycleObserver {

    private lateinit var welcomeViewModel: WelcomeViewModel

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated(){

        initializations()

    }

    private fun initializations() {
        val factory = WelcomeViewModel(UserExistRepo(RetrofitService(),welcomeActivity)).createFactory()
        val binding : ActivityWelcomeBinding = DataBindingUtil.setContentView(welcomeActivity, R.layout.activity_welcome)
        welcomeViewModel = ViewModelProvider(welcomeActivity,factory).get(WelcomeViewModel::class.java)
      //  (welcomeActivity.application as MyApp).myComponent.inject(welcomeActivity)

        binding.viewModel = welcomeViewModel
        sendFirebaseAnalytics(welcomeActivity.applicationContext,"Welcome",javaClass.name)
        statusBar(welcomeActivity)
        binding.user.text = welcomeActivity.retrieveUser("userName")

        welcomeViewModel.response.observe(welcomeActivity, Observer {

            if (it.statusCode == 200){
                welcomeActivity.let {activity ->
                    activity.customToast("Welcome to Home Screen")
                    activity.startActivity(Intent(welcomeActivity,HomeActivity::class.java))
                }
            }
            else {
                welcomeActivity.customToast(it.message)
            }
        })

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        sendFirebaseAnalytics(welcomeActivity.applicationContext,"Welcome",javaClass.name)
    }

}