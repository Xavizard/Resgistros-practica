package com.xavizard.registros

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.xavizard.registros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var profilePic: ImageView
    private var profileBitmap: Bitmap? = null

    val getContent = registerForActivityResult(ActivityResultContracts.TakePicturePreview()){
        bitmap ->
        profileBitmap = bitmap
        profilePic.setImageBitmap(profileBitmap!!)
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
        getContent.launch(null)
    }

    private fun openDetailActivity(persona: Persona){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.PERSON_KEY, persona)
        intent.putExtra(DetailActivity.BITMAP_KEY, profilePic.drawable.toBitmap())
        startActivity(intent)
    }

}