package com.van.nguyen.kotlin.adapter.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.van.nguyen.kotlin.R
import com.van.nguyen.kotlin.model.SampleModel

class SampleViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_sample, parent, false)) {
    private var txtItem: TextView? = null

    init {
        txtItem = itemView.findViewById(R.id.txtItem)
    }

    fun bindingData(movie: SampleModel) {
        txtItem?.text = movie.sampleName
    }

}