package com.app.tradesm8.views.activities.login

import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.app.tradesm8.utilities.common.BaseActivity
import com.app.tradesm8.utilities.common.customAlertDialog
import com.app.tradesm8.utilities.common.hideKeyboardActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(LoginObserver(this@LoginActivity))
    }

    override fun onBackPressed() {
        customAlertDialog(this)

    }

}