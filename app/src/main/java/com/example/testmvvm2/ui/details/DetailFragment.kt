package com.example.testmvvm2.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.testmvvm2.data.model.countries.CountriesResponseItem
import com.example.testmvvm2.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

	private var _binding: FragmentDetailBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentDetailBinding.inflate(layoutInflater)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		fillFields()
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	@SuppressLint("SetTextI18n")
	private fun fillFields() {
		if (arguments != null) {
			val country = arguments?.getParcelable<CountriesResponseItem>("country")
			binding.apply {
				textViewName.text = "Страна  : ${country?.name}"
				textViewRegion.text = "Регион  : ${country?.region}"
				textViewCapital.text = "Столица  : ${country?.capital}"
				textViewCurrency.text = "Валюта  : ${country?.currencies!![0].name}"
				textViewTimeZone.text = "Тайм зона  : ${country.timezones}"
				Glide.with(imageViewFlag).load(country.flags.png).into(imageViewFlag)
			}
		}
	}
}