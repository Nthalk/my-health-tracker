package com.nthalk.healthtracker.web.api

import com.nthalk.healthtracker.web.api.model.ApiResult
import com.nthalk.healthtracker.web.config.AppConfig
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/test")
@RestController
class ServerApi(appConfig: AppConfig) {

    data class ServerInfoResponse(
        val mapsApiKey: String
    )

    val serverInfoResponse = ApiResult(
        ServerInfoResponse(
            appConfig.googleMapsApiKey
        )
    )

    @PostMapping
    @ResponseBody
    fun info(): ApiResult<ServerInfoResponse> {
        return serverInfoResponse
    }
}
