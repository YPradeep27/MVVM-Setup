package com.app.tradesm8.views.activities.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.tradesm8.utilities.common.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(SplashObserver(this@SplashActivity))
    }
}