package com.app.tradesm8.models.login


class LoginUtil {



    /**
     * the input is not valid if
     * ...email is empty
     * ...password is empty
     * ...password length is not less than 6 digits
     * ...everything works perfectly
     */

    fun validateUser(

        email: String,
        password: String,
        ): Boolean {
        if (email.isEmpty()) {
            return false
        } else if (password.isEmpty()) {
            return false
        } else if (password.count { it.isDigit() } < 6) {
            return false
        }

        return true
    }

}