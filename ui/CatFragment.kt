package com.example.appi_application.ui

import android.os.Binder
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appi_application.R
import com.example.appi_application.databinding.FragmentCatBinding
import com.example.appi_application.ui.ViewModel.CarViewModel
import com.example.appi_application.ui.adapter.CarAdapter


class CatFragment() : Fragment(), SearchView.OnQueryTextListener{

    private lateinit var binding: FragmentCatBinding
    private val carViewModel by viewModels<CarViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCatBinding.inflate(inflater,container,false)

        binding.searchBar.setOnQueryTextListener(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        carViewModel.cars.observe(viewLifecycleOwner){
            if(!it.isNullOrEmpty()){
                binding.recyclerview.adapter = CarAdapter(it)
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrBlank()) {
            carViewModel.getCarsByBreed(query)
        }
        return true
    }
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}





