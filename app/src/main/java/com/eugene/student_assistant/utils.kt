package com.eugene.student_assistant

import android.content.Context
import android.widget.Toast
import com.eugene.student_assistant.models.User
import com.google.firebase.database.DataSnapshot

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,text, duration).show()
}
fun DataSnapshot.asUser(): User? =
    key?.let { getValue(User::class.java)?.copy(uid = it) }