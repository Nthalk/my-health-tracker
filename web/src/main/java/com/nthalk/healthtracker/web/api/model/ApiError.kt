package com.nthalk.healthtracker.web.api.model

data class ApiError(
    val code: ErrorCode,
    val message: String,
    val stack: String
)
