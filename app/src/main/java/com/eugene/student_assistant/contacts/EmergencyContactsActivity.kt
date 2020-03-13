package com.eugene.student_assistant.contacts

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.eugene.student_assistant.R

class EmergencyContactsActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_contacts)

        val callSecLine1 = findViewById<ImageView>(R.id.security_line1_call)
        val callSecLine2 = findViewById<ImageView>(R.id.security_line2_call)
        val callAmbLine1 = findViewById<ImageView>(R.id.ambulaance_line1_call)
        val callAmbLine2 = findViewById<ImageView>(R.id.ambulance_line2_call)

        callSecLine1.setOnClickListener(this)
        callSecLine2.setOnClickListener(this)
        callAmbLine1.setOnClickListener(this)
        callAmbLine2.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        when (v!!.getId()){
            R.id.security_line1_call ->{
                startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0712345678", null)))
            }
            R.id.security_line2_call ->{
                startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0712345678", null)))
            }
            R.id.ambulaance_line1_call ->{
                startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0712345678", null)))
            }
            R.id.ambulance_line2_call ->{
                startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0712345678", null)))
            }
        }

    }
}

