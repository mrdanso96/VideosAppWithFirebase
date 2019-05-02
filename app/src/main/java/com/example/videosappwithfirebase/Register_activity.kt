package com.example.videosappwithfirebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Register_activity : AppCompatActivity() {


    //declare variables
    var user_email:EditText?= null
    var user_password:EditText?= null
    var register_btn:Button?= null

    //to register a user
    var firebaseAuth:FirebaseAuth?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activity)

        //initialise variables/fetch views
        user_email = findViewById(R.id.user_register_email)
        user_password = findViewById(R.id.user_register_password_)
        register_btn = findViewById(R.id.register)
        firebaseAuth = FirebaseAuth.getInstance()

        register_btn?.setOnClickListener {

            RegisterUser()

        }

    }

    //method for registering user
    private fun RegisterUser(){

        var email = user_email?.text.toString().trim()
        var password = user_password?.text.toString().trim()

        //check if email and password fields are empty
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){

            Toast.makeText(applicationContext,"Make sure both email and password fields are not empty",Toast.LENGTH_SHORT).show()

        }
        else{

            //predefined method that creates user with email and password
            firebaseAuth?.createUserWithEmailAndPassword(email,password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult>{
                override fun onComplete(auth: Task<AuthResult>) {

                    if (auth.isSuccessful){

                        Toast.makeText(applicationContext,"Account Created",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@Register_activity,Login_activity::class.java))

                    }
                    else{

                        val error = auth.exception?.message
                        Toast.makeText(applicationContext,"Error " + error,Toast.LENGTH_SHORT).show()

                    }

                }

            })

        }

    }

}
