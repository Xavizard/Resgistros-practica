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
            openDetailActivity(personName, personCharge, chargeDescription, personRating) }

    }

    private fun openDetailActivity(personName: String, personCharge: String, chargeDescription: String, personRating: Float){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("person_name", personName)
        intent.putExtra("person_charge", personCharge)
        intent.putExtra("charge_description", chargeDescription)
        intent.putExtra("person_rating", personRating)
        startActivity(intent)
    }
}