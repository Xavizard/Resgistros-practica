package com.xavizard.registros

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.xavizard.registros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var profilePic: ImageView
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
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent,1000)
    }

    private fun openDetailActivity(persona: Persona){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.PERSON_KEY, persona)
        intent.putExtra(DetailActivity.BITMAP_KEY, profilePic.drawable.toBitmap())
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == 1000){
            val extras = data?.extras
            val personBitmap = extras?.getParcelable<Bitmap>("data")
            profilePic.setImageBitmap(personBitmap)
        }
    }

}