package com.app.tradesm8.utilities.dagger.modules

import androidx.lifecycle.ViewModelProvider
import com.app.tradesm8.utilities.common.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule
{
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}