package com.van.nguyen.kotlin.model

import android.content.Intent
import com.google.gson.GsonBuilder

class RegisterResponse : BaseModel() {
    var uuid: String? = null
    var token: String? = null

    companion object {
        fun fromJSON(json: String?): RegisterResponse {
            return GsonBuilder().create().fromJson(json, RegisterResponse::class.java)
        }

        fun fromIntent(intent: Intent): RegisterResponse {
            var streamResponse = RegisterResponse()
            if (intent.hasExtra(RegisterResponse::class.java.simpleName)) {
                streamResponse = fromJSON(
                    intent.getStringExtra(
                        RegisterResponse::class.java.simpleName
                    )
                )
            }
            return streamResponse
        }
    }
}