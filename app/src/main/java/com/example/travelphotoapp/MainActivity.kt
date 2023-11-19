package com.example.travelphotoapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var currentImage = 0
    private lateinit var image : ImageView
    private var titles = arrayOf("Lalibela", "Woldiya", "The Future", "The Monke", "Amibara")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<ImageButton>(R.id.btnNext)
        val btnPrev = findViewById<ImageButton>(R.id.btnPrev)
        val title = findViewById<TextView>(R.id.imagetitle)

        btnNext.setOnClickListener {
            var currentImageIdInString = "pic$currentImage"
            var currentImageIdInInt = this.resources.getIdentifier(currentImageIdInString, "id", packageName)
            image  = findViewById(currentImageIdInInt)
            image.alpha = 0f

            currentImage = (5+currentImage+ 1)%5

            var imageToShowInString = "pic$currentImage"
            var imageToShowInInt = this.resources.getIdentifier(imageToShowInString, "id", packageName)

            image = findViewById(imageToShowInInt)
            image.alpha = 1f

            // about the title
            title.text = titles[currentImage]

        }
        btnPrev.setOnClickListener {
            var currentImageIdInString = "pic$currentImage"
            var currentImageIdInInt = this.resources.getIdentifier(currentImageIdInString, "id", packageName)
            image  = findViewById(currentImageIdInInt)
            image.alpha = 0f

            currentImage = (5+currentImage-1)%5

            var imageToShowInString = "pic$currentImage"
            var imageToShowInInt = this.resources.getIdentifier(imageToShowInString, "id", packageName)

            image = findViewById(imageToShowInInt)
            image.alpha = 1f

            // about title
            title.text = titles[currentImage]
        }
    }
}