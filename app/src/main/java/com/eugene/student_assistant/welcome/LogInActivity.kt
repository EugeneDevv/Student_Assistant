package com.eugene.student_assistant.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.eugene.student_assistant.NavActivity
import com.eugene.student_assistant.R
import com.eugene.student_assistant.showToast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_log_in.login_btn
import kotlinx.android.synthetic.main.activity_log_in.txt_link

class LogInActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "LogInActivity"

    // declare firabase variables
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        //Get instance from firebase
        mAuth = FirebaseAuth.getInstance()
        if (mAuth.currentUser != null){
            startActivity(Intent(this, NavActivity::class.java))
            finish()
        }
        //set the onclick listener upon activity creation
        login_btn.setOnClickListener(this)
        txt_link.setOnClickListener(this)
        txt_password_link.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.login_btn -> {
                val email = edt_username.text.toString()
                val password = edt_password.text.toString()
                if (validate(email, password)) {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(this, NavActivity::class.java))
                            finish()
                        } else {
                            showToast("You must have entered the wrong Email or Password ")
                        }
                    }
                } else {
                    showToast("Please enter Email and Password")
                }
            }
            R.id.txt_link ->{
                startActivity(Intent(this,RegisterActivity::class.java))
            }
            R.id.txt_password_link ->{
                startActivity(Intent(this,PasswordReset::class.java))
            }
        }
    }

    private fun validate(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()
}