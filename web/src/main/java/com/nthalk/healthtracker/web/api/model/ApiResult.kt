package com.nthalk.healthtracker.web.api.model

import com.nthalk.healthtracker.web.annotations.Optional

data class ApiResult<T>(
    @get:Optional
    val result: T? = null,
    @get:Optional
    val error: RootApiError? = null
)
