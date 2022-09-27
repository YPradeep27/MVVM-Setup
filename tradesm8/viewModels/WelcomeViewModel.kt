package com.app.tradesm8.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.tradesm8.models.welcome.UserExistPOJO
import com.app.tradesm8.models.welcome.UserExistRepo
import com.app.tradesm8.utilities.common.coroutines.Coroutines
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(private val repo: UserExistRepo) : ViewModel() {

    var response : MutableLiveData<UserExistPOJO> = MutableLiveData()

    fun onWelcomeButton(view : View){

        Coroutines.main {
            response.value = repo.userExist(repo.retrieveUser("userId")!!)
        }

    }
}