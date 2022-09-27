package com.app.tradesm8.views.activities.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.app.tradesm8.R
import com.app.tradesm8.databinding.ActivitySplashBinding
import com.app.tradesm8.utilities.common.Constants.SPLASH_TIME_OUT
import com.app.tradesm8.utilities.common.retrieveUser
import com.app.tradesm8.utilities.common.sendFirebaseAnalytics
import com.app.tradesm8.views.activities.login.LoginActivity
import com.app.tradesm8.views.activities.welcome.WelcomeActivity

class SplashObserver(private val splashActivity: SplashActivity) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated(){

        val binding : ActivitySplashBinding = DataBindingUtil.setContentView(splashActivity, R.layout.activity_splash)
        sendFirebaseAnalytics(splashActivity.applicationContext,"Splash",javaClass.name)

        Handler(Looper.getMainLooper()).postDelayed({
            val email : String? = splashActivity.retrieveUser("email")
            val password : String? = splashActivity.retrieveUser("password")

            if(!email.equals("") && !password.equals("")){
                splashActivity.startActivity(Intent(splashActivity,WelcomeActivity::class.java))
            }
            else {
                splashActivity.startActivity(Intent(splashActivity, LoginActivity::class.java))
            }
        }, SPLASH_TIME_OUT.toLong())

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        sendFirebaseAnalytics(splashActivity.applicationContext,"Splash",javaClass.name)
    }
}