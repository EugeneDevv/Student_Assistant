package com.eugene.student_assistant.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.eugene.student_assistant.R
import com.eugene.student_assistant.showToast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_password_reset.*

class PasswordReset : AppCompatActivity(), View.OnClickListener {

    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        mAuth = FirebaseAuth.getInstance()

        reset_btn.setOnClickListener(this)
        reset_txt_login_link.setOnClickListener(this)
        txt_link_reset.setOnClickListener(this)
    }
    private fun PasswordReset(){
        val email = edt_username_reset?.text.toString().trim()

        if (TextUtils.isEmpty(email)){
            showToast("Please Enter your Email")
        } else{
            mAuth?.sendPasswordResetEmail(email).addOnCompleteListener(object : OnCompleteListener<Void> {
                override fun onComplete(task: Task<Void>) {
                    if (task.isSuccessful){
                        showToast("Check your Email for a Reset Password")
                    }else{
                        showToast("Something went wrong, please try again later")
                    }
                }
            })
        }
    }

    override fun onClick(view: View) {
        when (view.id){
            R.id.reset_btn ->{
                PasswordReset()
            }
            R.id.reset_txt_login_link ->{
                startActivity(Intent(this,LogInActivity::class.java))
            }
            R.id.txt_link_reset ->{
                startActivity(Intent(this,RegisterActivity::class.java))
            }
        }
    }
}