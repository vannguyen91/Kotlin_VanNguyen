package com.van.nguyen.kotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.van.nguyen.kotlin.R
import com.van.nguyen.kotlin.constrain.MESSAGES_DATA_KEY
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        changeTitle()
        startAnimationZoomIn()

        txtHello.setOnClickListener(this)
    }

    private fun changeTitle() {
        txtHello.text = "Hello My Kotlin Sample!!\nTap Here to continue"
    }

    private fun startAnimationZoomIn() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in_animation)
        txtHello.startAnimation(animation)
    }

    private fun startMainActivity() {
        val message = "Messages pass from intent";
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(MESSAGES_DATA_KEY, message)
        }
        startActivity(intent)
        finish()
    }

    override fun onClick(view: View?) {
        when (view) {
            txtHello -> startMainActivity()
        }
    }

}
