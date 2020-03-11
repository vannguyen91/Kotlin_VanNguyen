package com.van.nguyen.kotlin.model

class BaseResponse<T> {
    var statusCode = 0
    var success = false
    var error: ErrorResponse? = null
    var data: T? = null
}