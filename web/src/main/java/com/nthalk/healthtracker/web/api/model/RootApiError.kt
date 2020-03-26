package com.nthalk.healthtracker.web.api.model

import com.nthalk.healthtracker.web.annotations.Optional

data class RootApiError(
    val code: ErrorCode,
    val message: String,
    @get:Optional
    val stack: String? = null,
    @get:Optional
    val fieldErrors: Map<String, ApiError> = mapOf(),
    @get:Optional
    val globalErrors: List<ApiError> = listOf()
)
