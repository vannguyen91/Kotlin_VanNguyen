package com.van.nguyen.kotlin.constrain

import com.van.nguyen.kotlin.model.SampleModel

class DataLocal() {
    val SAMPLE_LIST = arrayListOf<String>(
        "Request API with Retrofit 2",
        "Request API with Retrofit and Rxjava",
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
        for ((index, item) in SAMPLE_LIST.withIndex()) {
            var sample = SampleModel()
            sample.sampleName = item;
            sample.tag = index

            listSample.add(sample)
        }
        return listSample;
    }
}