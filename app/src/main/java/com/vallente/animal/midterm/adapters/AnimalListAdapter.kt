package com.vallente.animal.midterm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.vallente.animal.midterm.R
import com.vallente.animal.midterm.dataModels.AnimalData


class AnimalListAdapter (private val animalList: List<AnimalData>) : BaseAdapter() {

    override fun getCount(): Int = animalList.size

    override fun getItem(position: Int): Any = animalList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(R.layout.list_item_animal, parent, false)

        val animalName = view.findViewById<TextView>(R.id.animalNameTextView)

        val animal = animalList[position]
        animalName.text = animal.animalName

        return view
    }
}
