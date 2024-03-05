package com.xavizard.registros

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import com.xavizard.registros.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var profilePic: ImageView
    private var profileBitmap: Bitmap? = null
    private var picPath = ""

    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()){
        success ->
        if(success && picPath.isNotEmpty()){
            profileBitmap = BitmapFactory.decodeFile(picPath)
            profilePic.setImageBitmap(profileBitmap)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val personName = binding.nombreEdit.text.toString()
            val personCharge = binding.cargoEdit.text.toString()
            val chargeDescription = binding.descriptionEdit.text.toString()
            val personRating = binding.rateBar.rating

            val persona = Persona(personName, personCharge, chargeDescription, personRating)
            openDetailActivity(persona)
        }

        profilePic = binding.profilePic
        profilePic.setOnClickListener {
            openCamera()
        }

    }

    private fun openCamera() {
        val file = createImageFile()
        val uri = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            FileProvider.getUriForFile(this,
                "$packageName.provider",
                file)
        } else {
            Uri.fromFile(file)
        }
        getContent.launch(uri)
    }

    private fun createImageFile():File {
        val fileName = "profilePicImage"
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File.createTempFile(fileName, ".jpg", fileDirectory)
        picPath =file.absolutePath
        return file
    }

    private fun openDetailActivity(persona: Persona){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.PERSON_KEY, persona)
        intent.putExtra(DetailActivity.BITMAP_KEY, profilePic.drawable.toBitmap())
        startActivity(intent)
    }

}