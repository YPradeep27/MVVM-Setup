package com.app.tradesm8

import android.app.Activity
import android.app.Application
import android.os.Bundle
//import com.app.tradesm8.utilities.dagger.components.DaggerMyComponent
import com.app.tradesm8.utilities.dagger.components.MyComponent
import com.google.firebase.FirebaseApp

class MyApp : Application() {

    lateinit var myComponent: MyComponent

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this);

       // myComponent = DaggerMyComponent.builder().build()
    }

}