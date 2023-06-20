package com.example.appi_application.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appi_application.databinding.ItemCarAdapterBinding

class CarAdapter(private val carList:List<String>):RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    inner class CarViewHolder ( val binding: ItemCarAdapterBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(car: String) {
            Glide.with(itemView.context).load(car).into(binding.ivImageCar)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CarViewHolder(binding = binding)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]

        holder.bind(car)
    }


}