package com.example.testmvvm2.ui.countries

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testmvvm2.data.model.countries.CountriesResponseItem
import com.example.testmvvm2.databinding.ItemCountryBinding

class CountriesAdapter(
	var countriesList: ArrayList<CountriesResponseItem>,
	val onClick: (CountriesResponseItem) -> Unit
) :
	RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

	fun setListCountries(list: ArrayList<CountriesResponseItem>){
		this.countriesList = list
		notifyDataSetChanged()
	}

	inner class CountriesViewHolder(var binding: ItemCountryBinding) :
		RecyclerView.ViewHolder(binding.root) {

		fun onBind(country: CountriesResponseItem) {
			binding.apply {
				textViewName.text = country.name
				Glide.with(imageViewFlag).load(country.flags.png).into(imageViewFlag)
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
		return CountriesViewHolder(
			ItemCountryBinding.inflate(
				LayoutInflater.from(parent.context),
				parent,
				false
			)
		)
	}

	override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
		holder.onBind(countriesList[position])
		holder.itemView.setOnClickListener {
			onClick(countriesList[position])
		}
	}

	override fun getItemCount(): Int {
		return countriesList.size
	}
}