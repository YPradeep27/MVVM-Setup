package com.app.tradesm8.utilities.common

import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.tradesm8.MyApp
import javax.inject.Inject

open class BaseActivity : AppCompatActivity()  {

   /* @Inject
    lateinit var factory: ViewModelProvider.Factory*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // (application as MyApp).myComponent.inject(this)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val v = currentFocus
        if (v != null && (ev.action == MotionEvent.ACTION_UP || ev.action == MotionEvent.ACTION_MOVE) && v is EditText && !v.javaClass.name.startsWith(
                "android.webkit.")
        ) {
            val scrCords = IntArray(2)
            v.getLocationOnScreen(scrCords)
            val x = ev.rawX + v.getLeft() - scrCords[0]
            val y = ev.rawY + v.getTop() - scrCords[1]
            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom()) hideKeyboardActivity(
                this)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onBackPressed() {
        customAlertDialog(this)
    }
}