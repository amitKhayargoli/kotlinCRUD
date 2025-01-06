package com.example.android.repository

import com.example.android.model.UserModel
import com.google.firebase.auth.FirebaseUser

interface UserRepository {

//    {
//        "success":true,
//        "message":"Login Success"
//    }

    fun login(email:String,password:String,callback:(Boolean,String)->Unit)

    fun signup(email:String,password:String,callback:(Boolean,String)->Unit)

    fun forgetPassword(email:String,callback: (Boolean, String) -> Unit)

    fun addUserToDatabase(userId:String,userModel: UserModel,callback: (Boolean, String) -> Unit)

    fun getCurrentUser() : FirebaseUser
}