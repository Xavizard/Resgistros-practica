package com.xavizard.registros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xavizard.registros.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val PERSON_KEY = "persona"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val persona = bundle.getParcelable<Persona>(PERSON_KEY)!!

        binding.personName.text = persona.name
        binding.personCharge.text = persona.charge
        binding.personDescription.text = persona.description
        binding.ratingBar.rating = persona.rate
    }
}