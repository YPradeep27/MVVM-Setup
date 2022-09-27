package com.app.tradesm8.viewModels

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.app.tradesm8.models.login.LoginRepo
import com.app.tradesm8.utilities.common.Constants
import com.app.tradesm8.utilities.common.coroutines.Coroutines
import com.app.tradesm8.views.activities.login.LoginListener
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginRepo: LoginRepo) : ViewModel() {

    var email: String? = null
    var password: String? = null

    var loginListener: LoginListener? = null

    fun onLoginButton(view: View) {

        if (!email.isNullOrEmpty()) {
            if (!password.isNullOrEmpty()) {

                FirebaseMessaging.getInstance().token.addOnCompleteListener {

                    if (!it.isSuccessful) {
                        Log.w(
                            "Token",
                            "Fetching FCM registration token failed",
                            it.exception
                        )
                        return@addOnCompleteListener
                    }

                    Coroutines.main {

                        val response = loginRepo.userLogin(
                            email!!,
                            password!!,
                            it.result.toString(),
                            Constants.DeviceType
                        )
                        if (response.body()?.statusCode == 200) {
                            loginRepo.saveUser("email", email!!)
                            loginRepo.saveUser("password", password!!)
                            loginRepo.saveUser("stripePublishKey", response.body()?.publishKey.toString())
                            loginRepo.saveUser("userName", response.body()?.username.toString())
                            loginRepo.saveUser("role", response.body()?.role.toString())
                            loginRepo.saveUser("permissionQuote", response.body()?.Quotes.toString())
                            loginRepo.saveUser("permissionCat", response.body()?.Categorie.toString())
                            loginRepo.saveUser("permissionOrders", response.body()?.Orders.toString())
                            loginRepo.saveUser("permissionProjectDetails", response.body()?.Project_Details.toString())
                            loginRepo.saveUser("permissionCatalogues", response.body()?.Catalogues.toString())
                            loginRepo.saveUser("permissionAllOrders", response.body()?.All_Orders.toString())
                            loginRepo.saveUser("permissionAwaiting", response.body()?.Orders_To_approve.toString())
                            loginRepo.saveUser("permissionSeeCost", response.body()?.Seecost.toString())
                            loginRepo.saveUser("permissionAddProduct", response.body()?.Addproduct.toString())
                            loginRepo.saveUser("awaitingData", response.body()?.numberofawating.toString())
                            loginRepo.saveUser("permissionWholeSeller", response.body()?.permission_wholeseller.toString())
                            loginRepo.saveUser("wholeSellerEngineerId", response.body()?.Wholeseller_engineer_id.toString())
                            loginRepo.saveUser("businessName", response.body()?.BussinessName.toString())
                            loginRepo.saveUser("viewWholeSellerPage", response.body()?.ViewWholesellerPage.toString())
                            loginRepo.saveUser("vanStock", response.body()?.vanstock.toString())
                            loginRepo.saveUser("permissionBrands", response.body()?.premissionbrand.toString())
                            loginRepo.saveUser("businessValidity", response.body()?.business_validity.toString())
                            loginRepo.saveUser("userId", response.body()?.id.toString())
                            loginListener?.onSuccess(response.body()!!)

                        }
                    }
                }


            } else {
                loginListener?.onFailure("Please Enter Password")
            }
        } else {
            loginListener?.onFailure("Please Enter Email Address")
        }

    }

    fun onForgotButton(view: View) {
        loginListener?.onStarted()
    }

    fun onTryFreeButton(view: View) {
        loginListener?.onSignup()
    }
}