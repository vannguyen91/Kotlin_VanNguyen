package com.van.nguyen.kotlin.constrain

import com.van.nguyen.kotlin.model.SampleModel

class DataLocal() {
    val SAMPLE_LIST = arrayListOf<String>(
        "Request API with Retrofit 2",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A",
        "A"
    )

    fun getListSample(): ArrayList<SampleModel> {
        val listSample = arrayListOf<SampleModel>()
        for (item in SAMPLE_LIST) {
            listSample.add(SampleModel(item))
        }
        return listSample;
    }
}