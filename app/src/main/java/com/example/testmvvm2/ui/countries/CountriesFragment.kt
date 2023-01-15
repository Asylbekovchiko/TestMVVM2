package com.example.testmvvm2.ui.countries

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testmvvm2.R
import com.example.testmvvm2.data.model.countries.CountriesResponseItem
import com.example.testmvvm2.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {

	private var _binding: FragmentCountriesBinding? = null
	private val binding get() = _binding!!

	private lateinit var viewModel: CountriesViewModel
	private lateinit var list: ArrayList<CountriesResponseItem>
	private lateinit var adapter: CountriesAdapter

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentCountriesBinding.inflate(layoutInflater)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setViewModel()
		setAdapter()
		getCountries()
		observeLiveData()
		setClickListeners()
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	private fun setViewModel() {
		viewModel = ViewModelProvider(this).get(CountriesViewModel::class.java)
	}

	private fun setAdapter() {
		list = ArrayList()
		adapter = CountriesAdapter(list) {
			val bundle = Bundle()
			bundle.putParcelable("country", it)
			findNavController().navigate(R.id.action_countriesFragment_to_detailFragment, bundle)
		}
		binding.recyclerView.adapter = adapter
	}

	private fun getCountries() {
		viewModel.getCountries()
	}

	private fun observeLiveData() {
		viewModel.apply {
			successLiveData.observe(requireActivity()) {
				adapter.setListCountries(it)
			}

			errorLiveData.observe(requireActivity()) { errorText ->
				Log.e("ERROR", errorText)
			}
		}
	}

	private fun setClickListeners() {
		binding.buttonUpdate.setOnClickListener {
			viewModel.getCountries()
			binding.recyclerView.adapter = adapter
		}
	}
}