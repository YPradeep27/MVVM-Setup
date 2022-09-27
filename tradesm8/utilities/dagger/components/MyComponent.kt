package com.app.tradesm8.utilities.dagger.components

import com.app.tradesm8.utilities.common.BaseActivity
import com.app.tradesm8.utilities.dagger.annotations.scopes.ApplicationScope
import com.app.tradesm8.utilities.dagger.modules.RetrofitModule
import com.app.tradesm8.utilities.dagger.modules.ViewModelModule
import com.app.tradesm8.views.activities.forgot.ForgotActivity
import dagger.Component

@ApplicationScope
@Component(modules = [RetrofitModule::class,ViewModelModule::class])
interface MyComponent {

    fun inject(activity: ForgotActivity)
}