package com.vallente.animal.midterm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AlertDialog
import com.vallente.animal.midterm.adapters.AnimalListAdapter
import com.vallente.animal.midterm.dataModels.AnimalData
import com.vallente.animal.midterm.databinding.ActivityAnimalNamesBinding
import org.json.JSONArray
import kotlin.system.exitProcess

class AnimalNamesActivity : Activity() {

    private lateinit var binding: ActivityAnimalNamesBinding

    private val animalList = mutableListOf<AnimalData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Animal names from A-Z"

        val adapter = AnimalListAdapter(animalList)
        binding.animalListView.adapter = adapter

        binding.animalListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedAnimal = animalList[position]
            startActivity(
                Intent(this, AnimalDetailsActivity::class.java).apply {
                    putExtra("animalData", selectedAnimal)
                }
            )
        }

        binding.manageBlockAnimalButton.setOnClickListener {
            val intent = Intent(this@AnimalNamesActivity, ManageBlockActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initializeAnimalListFromJson() {
        val jsonString = """
            [
                {"name": "Alligator", "description": "Alligators are large, semi-aquatic reptiles with powerful jaws, found in the southeastern United States and China."},
                {"name": "Bear", "description": "Bears are large, shaggy mammals found in various habitats, known for their strength and hibernation habits."},
                {"name": "Cow", "description": "Cows are domesticated herbivores often seen on farms, raised for milk, meat, and other agricultural products."},
                {"name": "Dolphin", "description": "Dolphins are intelligent marine mammals that live in oceans, known for their playful behavior and communication abilities."},
                {"name": "Elephant", "description": "Elephants are massive land mammals with long trunks and large ears, recognized for their intelligence and strong family bonds."},
                {"name": "Flamingo", "description": "Tall wading birds with long legs and distinctive pink plumage, often seen in wetlands and shallow waters."},
                {"name": "Giraffe", "description": " Giraffes are tall, long-necked herbivores found in Africa, known for their distinctive spotted coats and towering height."},
                {"name": "Hedgehog", "description": "Hedgehogs are small, spiky mammals with a nocturnal lifestyle, commonly found in Europe, Asia, and Africa."},
                {"name": "Iguana", "description": "Iguanas are reptiles with spiky appearance, often found in tropical regions of Central and South America."},
                {"name": "Jaguar", "description": "Jaguars are powerful big cats with striking rosette patterns, native to the Americas and known for their elusive nature."},
                {"name": "Koala", "description": "Koalas are marsupials native to Australia, recognized for their cute appearance, eucalyptus leaf diet, and tree-dwelling habits."},
                {"name": "Lion", "description": " Lions are majestic big cats native to parts of Africa, known for their social behavior and iconic status as the king of the jungle."},
                {"name": "Rabbit", "description": "Small mammals with long ears and a penchant for burrowing, kept as pets and found in various habitats worldwide."},
                {"name": "Tiger", "description": "The largest big cat species with distinctive orange fur and black stripes, native to Asia and known for its strength and beauty."},
                {"name": "Zebra", "description": "Striped, horse-like mammals found in Africa, with various species sporting black and white or brown and white stripes."}
            ]
        """.trimIndent()

        val jsonArray = JSONArray(jsonString)

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val animalData = AnimalData(jsonObject.getString("name"), jsonObject.getString("description"))
            animalList.add(animalData)
        }
    }

    init {
        initializeAnimalListFromJson()
    }

    @Deprecated("This method is intentionally overridden due to deprecation in the parent class.")
    override fun onBackPressed() {
        showExitConfirmation()
    }

    private fun showExitConfirmation() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure you want to exit?")
        builder.setPositiveButton("Yes") { _, _ ->
            finishAffinity()
            exitProcess(0)
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }


}
