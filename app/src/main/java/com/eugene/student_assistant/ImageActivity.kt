package com.eugene.student_assistant_assistant

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.eugene.student_assistant.R

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val galleryButton = findViewById<Button>(R.id.gallery_btn)
        val cameraButton = findViewById<Button>(R.id.camera_btn)

        cameraButton.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,111)
        }

        galleryButton.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent,222)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111){
            val image = data!!.extras?.get("data") as Bitmap
            val image_view = findViewById<ImageView>(R.id.image_view)

            image_view.setImageBitmap(image)


        }
        if (requestCode == 222){
            if ( data != null){
                val imageUri = data.data

                val imageView = findViewById<ImageView>(R.id.image_view)
                imageView.setImageURI(imageUri)
            }
        }
    }
}
