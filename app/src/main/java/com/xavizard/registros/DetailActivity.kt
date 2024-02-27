package com.xavizard.registros

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xavizard.registros.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val PERSON_KEY = "persona"
        const val BITMAP_KEY = "bitmap"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val persona = bundle.getParcelable<Persona>(PERSON_KEY)!!
        val bitmap = bundle.getParcelable<Bitmap>(BITMAP_KEY)!!

        binding.personImage.setImageBitmap(bitmap)
        binding.persona = persona
    }
}