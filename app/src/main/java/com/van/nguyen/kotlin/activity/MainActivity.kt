package com.van.nguyen.kotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.van.nguyen.kotlin.R
import com.van.nguyen.kotlin.adapter.SampleAdapter
import com.van.nguyen.kotlin.constrain.DataLocal
import com.van.nguyen.kotlin.constrain.MESSAGES_DATA_KEY
import com.van.nguyen.kotlin.interfaces.SampleInterface
import com.van.nguyen.kotlin.model.SampleModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mAdapter: SampleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message = intent.getStringExtra(MESSAGES_DATA_KEY)
        bindingData()
    }

    fun bindingData() {
        val listSample = DataLocal().getListSample();
        mAdapter = SampleAdapter(listSample)
        recycleSample.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }
        mAdapter.setItemClick(object : SampleInterface {
            override fun onItemCLick(sample: SampleModel) {
                var intent: Intent = Intent()
                if (sample.tag == 0) {
                    intent = Intent(this@MainActivity, RequestAPIActivity::class.java)
                }
                if (sample.tag == 1) {
                    intent = Intent(this@MainActivity, RequestAPIWithRx::class.java)
                }
                startActivity(intent)
                finish()
            }

        })
    }

}
