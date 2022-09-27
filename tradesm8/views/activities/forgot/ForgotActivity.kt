package com.app.tradesm8.views.activities.forgot

import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.tradesm8.MyApp
import com.app.tradesm8.utilities.common.BaseActivity
import com.app.tradesm8.utilities.common.hideKeyboardActivity
import javax.inject.Inject

class ForgotActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(ForgotObserver(this@ForgotActivity))
    }

}