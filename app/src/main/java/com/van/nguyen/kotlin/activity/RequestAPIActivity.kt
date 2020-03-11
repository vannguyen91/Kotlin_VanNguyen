package com.van.nguyen.kotlin.activity

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.duong.appnews.Service.API
import com.van.nguyen.kotlin.R
import com.van.nguyen.kotlin.dialog.CustomProgressBar
import com.van.nguyen.kotlin.model.BaseResponse
import com.van.nguyen.kotlin.model.RegisterResponse
import com.van.nguyen.kotlin.model.RequestRegisterAccount
import kotlinx.android.synthetic.main.activity_request_api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestAPIActivity : AppCompatActivity() {
    val progressBar = CustomProgressBar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_api)

        btnLogin.setOnClickListener(object : OnClickListener {
            override fun onClick(view: View?) {
                var request = RequestRegisterAccount()
                request.email = txtName.text.toString().trim()
                request.password = txtPass.text.toString().trim()
                request.ver = "1.2.0"
                request.device = "Android"

                callAPiLogin(request)
            }
        })
    }

    fun callAPiLogin(request: RequestRegisterAccount) {
        progressBar.show(this, "Please Wait...")
        API.apiService.login(request)?.enqueue(object : Callback<BaseResponse<RegisterResponse?>?> {
            override fun onResponse(
                call: Call<BaseResponse<RegisterResponse?>?>,
                response: Response<BaseResponse<RegisterResponse?>?>
            ) {
                if (response.body() != null && response.body()!!.data != null && response.body()!!.success) {
                    txtResponse.text = "Your Token: " + response.body()!!.data?.token.toString()
                } else {
                    txtResponse.text = response.body()?.error?.message ?: "Unknow error"
                }
                progressBar.dialog.dismiss()
            }

            override fun onFailure(
                call: Call<BaseResponse<RegisterResponse?>?>,
                t: Throwable
            ) {
                txtResponse.text = t.message
                progressBar.dialog.dismiss()
            }
        })
    }


}
