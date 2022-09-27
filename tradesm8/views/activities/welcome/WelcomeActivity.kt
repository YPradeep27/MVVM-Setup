package com.app.tradesm8.views.activities.welcome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.tradesm8.utilities.common.BaseActivity
import com.app.tradesm8.utilities.common.customAlertDialog

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(WelcomeObserver(this@WelcomeActivity))

    }
}