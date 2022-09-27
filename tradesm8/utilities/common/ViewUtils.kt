package com.app.tradesm8.utilities.common

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.tradesm8.R
import com.app.tradesm8.utilities.common.Constants.AlertBoxText
import com.app.tradesm8.utilities.common.Constants.No
import com.app.tradesm8.utilities.common.Constants.Yes
import com.app.tradesm8.views.activities.login.LoginActivity
import com.google.firebase.analytics.FirebaseAnalytics


fun Context.customToast(message : String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun Context.saveUser(key: String , value : String){
    val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
    val editor=preference.edit()
    editor.putString(key,value)
    editor.apply()
}

fun Context.retrieveUser(key: String) : String?{
    val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
    return preference.getString(key,"")
}

fun retrieveUser2(context: Context?,key: String) : String?{
    val preference=
        context!!.getSharedPreferences(context.resources.getString(R.string.app_name), Context.MODE_PRIVATE)
    return preference.getString(key,"")
}

fun Context.customAlertDialog(activity: Activity) {

    val alertDialog = AlertDialog.Builder(this)

    alertDialog.apply {
        setMessage(AlertBoxText)
        setCancelable(false)
        setPositiveButton(Yes) { _: DialogInterface?, _: Int ->

            activity.onBackPressed()
            activity.finish()

        }
        setNegativeButton(No) { _, _ ->
        }
    }.create().show()

}

fun sendFirebaseAnalytics( context: Context?,ScreenName: String?, ScreenClass: String?) {
    val mFirebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
    val bundle = Bundle()
    bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, ScreenName)
    bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, ScreenClass)
    mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
}

fun statusBar(activity: Activity) {
    if (Build.VERSION.SDK_INT >= 21) {
        val window = activity.window
        window.let {
            it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            it.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            it.statusBarColor = activity.resources.getColor(R.color.white)
            it
        }
    }
}

fun Context.progressBarShow() {
        val progressDialog = ProgressDialog(this, R.style.AlertDialogCustom)
        progressDialog.let {
            it.setCancelable(false)
            it.setMessage("Please Wait.......")
            it.show()
            it
        }

    }

fun hideKeyboardActivity(activity: Activity?) {
        if (activity != null && activity.window != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(activity.window.decorView.windowToken, 0)
        }
    }

fun hideKeyboard(view: View, context: Context) {
    val inputMethodManager =
        context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

//ViewModel Factory
fun <T : ViewModel> T.createFactory(): ViewModelProvider.Factory {
    val viewModel = this
    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModel as T
    }
}


