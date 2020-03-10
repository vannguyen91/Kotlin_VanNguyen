package com.van.nguyen.kotlin.adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.van.nguyen.kotlin.adapter.viewHolder.SampleViewHolder
import com.van.nguyen.kotlin.model.SampleModel

class SampleAdapter(private val list: List<SampleModel>) :
    RecyclerView.Adapter<SampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SampleViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        val sample: SampleModel = list[position]
        holder.bindingData(sample)
    }

    override fun getItemCount(): Int = list.size

}