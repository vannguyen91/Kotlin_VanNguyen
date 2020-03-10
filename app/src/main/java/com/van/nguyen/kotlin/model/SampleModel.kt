package com.van.nguyen.kotlin.model

import android.os.Parcel
import android.os.Parcelable

class SampleModel {
    var sampleName: String = ""
    var tag: Int = 0;

    constructor() {}

    constructor(sampleName: String, tag: Int) {
        this.sampleName = sampleName
        this.tag = tag;
    }
}
