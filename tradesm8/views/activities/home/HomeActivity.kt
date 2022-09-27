package com.app.tradesm8.views.activities.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.app.tradesm8.R
import com.app.tradesm8.utilities.common.BaseActivity
import com.app.tradesm8.utilities.common.customAlertDialog
import com.app.tradesm8.views.fragments.category.CategoryFragment

class HomeActivity : BaseActivity() {

    private lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(HomeObserver(this@HomeActivity))

        transaction = supportFragmentManager.beginTransaction().addToBackStack(null).add(R.id.container, CategoryFragment())
        transaction.commitAllowingStateLoss()
    }

}