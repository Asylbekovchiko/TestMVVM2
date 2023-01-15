package com.example.testmvvm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.testmvvm2.databinding.ActivityMainBinding
import com.example.testmvvm2.databinding.FragmentCountriesBinding

class MainActivity : AppCompatActivity() {

	private var _binding: ActivityMainBinding? = null
	private val binding get() = _binding!!

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		setNavComponents()
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}

	private fun setNavComponents() {
		val navHostFragment =
			supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
		val navController = navHostFragment.findNavController()
		navController.navigate(R.id.countriesFragment)
	}
}