package com.nthalk.healthtracker.web.api

import com.nthalk.healthtracker.web.api.model.ApiResult
import org.jooq.DSLContext
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/health-check")
@RestController
class HealthCheckApi(val db: DSLContext) {
    data class CheckIn(val temperature: Float)

    @PostMapping("check-in")
    @ResponseBody
    fun checkIn(@RequestBody checkIn: CheckIn): ApiResult<Unit> {
        db.newRecord()
        return ApiResult()
    }
}
