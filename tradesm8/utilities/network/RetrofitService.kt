package com.app.tradesm8.utilities.network

import com.app.tradesm8.models.category.CategoryPOJO
import com.app.tradesm8.models.forgot.ForgotPOJO
import com.app.tradesm8.models.login.LoginPOJO
import com.app.tradesm8.models.welcome.UserExistPOJO
import com.app.tradesm8.utilities.common.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitService {

    companion object{
        operator fun invoke() : RetrofitService {
            return Retrofit.Builder()
                .baseUrl(Constants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService::class.java)
        }
    }

    @FormUrlEncoded
    @POST("user_verification")
    suspend fun userLogin(
        @Field("email") email : String,
        @Field("password") password : String,
        @Field("deviceid") deviceId : String,
        @Field("devicestatus") deviceStatus : String
    ) : Response<LoginPOJO>


    @FormUrlEncoded
    @POST("forgotpassword")
    suspend fun forgotPassword(
        @Field("email") email : String
    ) : ForgotPOJO


    @FormUrlEncoded
    @POST("CheckUserExist")
    suspend fun userExist(
        @Field("user_id") user_id : String
    ) : UserExistPOJO

    @FormUrlEncoded
    @POST("getproductcategory")
    suspend fun getCategories(
        @Field("userid") userId : String,
        @Field("isVan") isVan : String
    ) : CategoryPOJO
}