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

class Login_activity : AppCompatActivity() {

    //declare variables
    var user_email: EditText?= null
    var user_password: EditText?= null
    var login_btn: Button?= null

    //to get a user
    var firebaseAuth: FirebaseAuth?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)

        //initialise variables/fetch views
        user_email = findViewById(R.id.user_login_email)
        user_password = findViewById(R.id.user_login_password_)
        login_btn = findViewById(R.id.login)

        //get instance of user
        firebaseAuth = FirebaseAuth.getInstance()

        login_btn?.setOnClickListener {

            LoginUser()

        }

    }

    private fun LoginUser(){

        var email = user_email?.text.toString().trim()
        var password = user_password?.text.toString().trim()

        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){

            Toast.makeText(applicationContext,"Make sure both email and password fields are not empty", Toast.LENGTH_SHORT).show()

        }
        else{

            //predefined method that signs in a user with email and password
            firebaseAuth?.signInWithEmailAndPassword(email,password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult>{
                override fun onComplete(auth: Task<AuthResult>) {

                    if (auth.isSuccessful){

                        Toast.makeText(applicationContext,"You are LoggedIn Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@Login_activity,Dashboard_activity::class.java))

                    }
                    else{

                        var error = auth.exception?.message
                        Toast.makeText(applicationContext,"Error " + error, Toast.LENGTH_SHORT).show()

                    }

                }

            })

        }

    }

}
