package com.example.android

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android.databinding.ActivityRegisterBinding
import com.example.android.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {
    lateinit var binding:ActivityRegisterBinding
    lateinit var auth : FirebaseAuth

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference : DatabaseReference = database.reference.child("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.signupBtn.setOnClickListener{
            var email : String = binding.signupEmail.text.toString()
            var password : String = binding.signupPass.text.toString()
            var fName : String = binding.firstName.text.toString()
            var lName : String = binding.lastName.text.toString()

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{

                if(it.isSuccessful){
                    val userId = auth.currentUser?.uid

                    val userModel = UserModel(userId.toString(),email,fName,lName)

                    reference.child(userId.toString()).setValue(userModel)

                    if(it.isSuccessful){
                        Toast.makeText(this@Register,"Registration Success", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this@Register,
                            it.exception?.message,Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this@Register,
                        it.exception?.message,Toast.LENGTH_SHORT).show()
                }
            }





        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}