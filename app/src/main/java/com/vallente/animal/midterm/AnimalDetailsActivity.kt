package com.vallente.animal.midterm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.vallente.animal.midterm.dataModels.AnimalData
import com.vallente.animal.midterm.databinding.ActivityAnimalDetailsBinding

class AnimalDetailsActivity : Activity() {

    private lateinit var binding: ActivityAnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Animal Details"

        @Suppress("DEPRECATION")
        val animalData = intent.getParcelableExtra<AnimalData>("animalData")

        val animalName = binding.animalNameTextView
        val animalDescription = binding.animalDescriptionTextView


        if (animalData != null) {
            animalName.text = animalData.animalName
            animalDescription.text = animalData.animalDescription
        } else {
            Toast.makeText(this, "Error: Animal Data is null", Toast.LENGTH_SHORT).show()
        }

    }
    @Deprecated("This method is intentionally overridden due to deprecation in the parent class.")
    override fun onBackPressed() {
        val intent = Intent(this@AnimalDetailsActivity, AnimalNamesActivity::class.java)
        startActivity(intent)
        finish()
    }
}
