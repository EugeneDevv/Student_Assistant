package com.eugene.student_assistant.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.eugene.student_assistant.NavActivity
import com.eugene.student_assistant.R
import com.eugene.student_assistant.models.User
import com.eugene.student_assistant.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "RegisterActivity"
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        register_btn.setOnClickListener(this)
        register_txt_link.setOnClickListener {
            startActivity(Intent(this,LogInActivity::class.java))
        }
    }
    private fun onRegister(){
        val fullName = edt_fullname.text.toString()
        val admNumber = edt_admNumber.text.toString()
        val email = register_edt_email.text.toString()
        val password = register_edt_password.text.toString()
        val confirmPassword = edt_confirm_password.text.toString()

        if (fullName.isEmpty() || admNumber.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            showToast("All fields are required")
        }else{
            if (password == confirmPassword){
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            val user = makeUser(fullName, admNumber, email)
                            val reference = mDatabase.child("users").child(it.result?.user!!.uid)
                            reference.setValue(user)
                                .addOnCompleteListener {
                                    if (it.isSuccessful){
                                        showToast("Registration was successful")
                                        startActivity(Intent(this, NavActivity::class.java))
                                        finish()
                                    }else{
                                        showToast("Something went wrong, please try again later")
                                    }
                                }
                        }else{
                            showToast("Something went wrong, please try again later")
                        }
                    }
            }else{
                showToast("Passwords must match")
            }
        }
    }

    override fun onClick(view: View) {
        when (view.id){
            R.id.register_btn ->{
                onRegister()
            }
        }
    }
    private fun makeUser(Name: String, ADMnumber: String, email: String): User {
        return User(fullName = Name,email= email, admNumber = ADMnumber)
    }
}