package com.van.nguyen.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.van.nguyen.kotlin.R
import com.van.nguyen.kotlin.api.API
import com.van.nguyen.kotlin.dialog.CustomProgressBar
import com.van.nguyen.kotlin.model.BaseResponse
import com.van.nguyen.kotlin.model.RegisterResponse
import com.van.nguyen.kotlin.model.RequestRegisterAccount
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_request_api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestAPIWithRx : AppCompatActivity() {
    val progressBar = CustomProgressBar()
    private var mCompositeDisposable: CompositeDisposable? = null

    var timeCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_apiwith_rx)

        // init CompositeDisposable
        mCompositeDisposable = CompositeDisposable()

        btnLogin.setOnClickListener(object : View.OnClickListener {
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
        mCompositeDisposable?.add(API.apiService.loginWithRxJava(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> onLoginSuccess(result) },
                { error -> onLoginError(error) },
                { onCompleteRequest() }
            )
        )
    }

    private fun onLoginError(error: Throwable) {
        txtResponse.append("Request Time: " + ++timeCount + "\n")
        txtResponse.append(error?.message ?: "Unknow error")
        progressBar.dialog.dismiss()
    }

    private fun onLoginSuccess(response: BaseResponse<RegisterResponse>) {
        txtResponse.append("Request Time: " + ++timeCount + "\n")
        if (response.data != null && response.success) {
            txtResponse.append("Your Token: " + response.data?.token.toString())
        } else {
            txtResponse.append(response.error?.message ?: "Unknow error")
        }
        progressBar.dialog.dismiss()
    }

    private fun onCompleteRequest() {
        progressBar.dialog.dismiss()
    }

}
