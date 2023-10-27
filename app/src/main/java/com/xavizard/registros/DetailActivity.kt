package com.xavizard.registros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.xavizard.registros.databinding.ActivityDetailBinding
import java.util.zip.Inflater

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val personName = bundle.getString("person_name")
        val personCharge = bundle.getString("person_charge")
        val chargeDescription = bundle.getString("charge_description")
        val personRating = bundle.getFloat("person_rating")

        binding.personName.text = personName
        binding.personCharge.text = personCharge
        binding.personDescription.text = chargeDescription
        binding.ratingBar.rating = personRating
    }
}