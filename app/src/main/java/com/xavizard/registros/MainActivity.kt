package com.xavizard.registros

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xavizard.registros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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
            openDetailActivity(persona) }

    }

    private fun openDetailActivity(Persona: Persona){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(DetailActivity.PERSON_KEY, Persona)
        startActivity(intent)
    }
}