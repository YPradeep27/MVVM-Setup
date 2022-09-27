package com.app.tradesm8.models.login

import com.google.gson.annotations.SerializedName


data class LoginPOJO(
    val `0`: String,
    val Addproduct: String,
    val Addtocart: String,
    val All_Orders: String,
    val Business_id: String,
    val BussinessName: String,
    val Catalogues: String,
    val Categorie: String,
    var Message: String,
    val Orders: String,
    val Orders_To_approve: String,
    val Project_Details: String,
    val Quotes: String,
    val Seecost: String,
    val ViewWholesellerPage: String,
    val Wholeseller_engineer_id: String,
    val basic_user: String,
    val business_validity: String,
    val first_name: String,
    val id: String,
    val image: String,
    val last_name: String,
    val numberofawating: Int,
    val permission_wholeseller: String,
    val premissionbrand: String,
    val premissioncard: String,
    val publishKey: String,
    val role: String,
    val statusCode: Int,
    @SerializedName("user name") val username: String,
    val valid: Boolean,
    val vanstock: Int
)