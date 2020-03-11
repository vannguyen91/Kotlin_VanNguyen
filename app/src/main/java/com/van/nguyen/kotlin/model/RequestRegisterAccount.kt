package com.van.nguyen.kotlin.model

class RequestRegisterAccount : BaseModel {
    var email: String = ""
    var password: String = ""
    var ver: String? = null
    var device: String? = null

    constructor() {

    }

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    constructor(
        email: String,
        password: String,
        ver: String?,
        device: String?
    ) {
        this.email = email
        this.password = password
        this.ver = ver
        this.device = device
    }
}