package com.van.nguyen.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.van.nguyen.kotlin.R
import com.van.nguyen.kotlin.adapter.SampleAdapter
import com.van.nguyen.kotlin.constrain.DataLocal
import com.van.nguyen.kotlin.constrain.MESSAGES_DATA_KEY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message = intent.getStringExtra(MESSAGES_DATA_KEY)
        bindingData()
    }

    fun bindingData() {
        val listSample = DataLocal().getListSample();

        recycleSample.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = SampleAdapter(listSample)
        }
    }

}
