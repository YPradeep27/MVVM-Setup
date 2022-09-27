package com.app.tradesm8.views.activities.home

import android.annotation.SuppressLint
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.app.tradesm8.MyApp
import com.app.tradesm8.R
import com.app.tradesm8.databinding.ActivityHomeBinding
import com.app.tradesm8.utilities.common.retrieveUser
import com.app.tradesm8.utilities.common.sendFirebaseAnalytics
import com.app.tradesm8.utilities.common.statusBar
import com.google.android.material.navigation.NavigationView


@SuppressLint("RestrictedApi")
class HomeObserver(private val homeActivity: HomeActivity) : LifecycleObserver {

    private lateinit var navigationView: NavigationView
    private lateinit var headerView : View
    private lateinit var navUserName: TextView
    private lateinit var menu : Menu

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated(){

        initializations()
        navigationViewCall()

    }

    private fun initializations() {

        val binding : ActivityHomeBinding = DataBindingUtil.setContentView(homeActivity, R.layout.activity_home)
       // (homeActivity.application as MyApp).myComponent.inject(homeActivity)
        navigationView = binding.navigationView
        headerView = navigationView.getHeaderView(0)
        navUserName = headerView.findViewById<TextView>(R.id.navHeaderName)
        menu = navigationView.menu

        sendFirebaseAnalytics(homeActivity.applicationContext,"Home",javaClass.name)
        statusBar(homeActivity)
    }

    private fun navigationViewCall() {

        navUserName.text = homeActivity.retrieveUser("userName")
        menu.findItem(R.id.navCategory).isVisible = true

        menu.run {

            findItem(R.id.navVanStock).isVisible = homeActivity.retrieveUser("vanStock").equals("1")
            findItem(R.id.navStockOrder).isVisible = homeActivity.retrieveUser("vanStock").equals("1")
            findItem(R.id.navCategory).isVisible = homeActivity.retrieveUser("permissionCat").equals("1")
            findItem(R.id.navOrder).isVisible = homeActivity.retrieveUser("permissionOrders").equals("1")
            findItem(R.id.navProjectDetails).isVisible = homeActivity.retrieveUser("permissionProjectDetails").equals("1")
            findItem(R.id.navBrands).isVisible = homeActivity.retrieveUser("permissionBrands").equals("1")
            findItem(R.id.navCatalogue).isVisible = homeActivity.retrieveUser("permissionCatalogues").equals("1")
            findItem(R.id.navQuotes).isVisible = homeActivity.retrieveUser("permissionQuote").equals("1")
            findItem(R.id.navWholeSellers).isVisible = homeActivity.retrieveUser("permissionWholeSeller").equals("1")
        }
    }
}