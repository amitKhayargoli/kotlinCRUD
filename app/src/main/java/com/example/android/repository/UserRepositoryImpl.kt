package com.example.android.repository

import com.example.android.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UserRepositoryImpl :UserRepository {

    var auth : FirebaseAuth = FirebaseAuth.getInstance();

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference : DatabaseReference = database.reference.child("users")

    override fun login(email: String, password: String, callback: (Boolean, String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun signup(email: String, password: String, callback: (Boolean, String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun forgetPassword(email: String, callback: (Boolean, String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun addUserToDatabase(
        userId: String,
        userModel: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): FirebaseUser {
        TODO("Not yet implemented")
    }

}