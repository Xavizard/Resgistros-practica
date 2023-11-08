package com.xavizard.registros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xavizard.registros.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val PERSON_NAME = "person_name"
        const val PERSON_CHARGE = "person_charge"
        const val CHARGE_DESCRIPTION = "charge_description"
        const val PERSON_RATING = "person_rating"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val personName = bundle.getString(PERSON_NAME) ?: ""
        val personCharge = bundle.getString(PERSON_CHARGE) ?: ""
        val chargeDescription = bundle.getString(CHARGE_DESCRIPTION) ?: ""
        val personRating = bundle.getFloat(PERSON_RATING)

        binding.personName.text = personName
        binding.personCharge.text = personCharge
        binding.personDescription.text = chargeDescription
        binding.ratingBar.rating = personRating
    }
}