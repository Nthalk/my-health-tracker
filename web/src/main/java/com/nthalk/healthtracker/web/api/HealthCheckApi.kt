package com.nthalk.healthtracker.web.api

import com.nthalk.healthtracker.db.models.Tables
import com.nthalk.healthtracker.db.models.Tables.*
import com.nthalk.healthtracker.web.api.model.ApiResult
import org.jooq.DSLContext
import org.springframework.web.bind.annotation.*
import java.time.OffsetDateTime

@RequestMapping("/api/health-check")
@RestController
class HealthCheckApi(val db: DSLContext) {
    data class CheckIn(
        val coldSweatsScale: Int,
        val congestionScale: Int,
        val feverStartAt: OffsetDateTime,
        val gpsAccuracy: Double,
        val gpsLatitude: Double,
        val gpsLongitude: Double,
        val sensitiveSkinScale: Int,
        val soreThroatScale: Int,
        val temperature: Float,
        val token: String
    )

    @PostMapping("check-in")
    @ResponseBody
    fun checkIn(@RequestBody checkIn: CheckIn): ApiResult<Unit> {
        val rec = db.newRecord(USER_CHECKIN)
        rec.coldSweatsScale = checkIn.coldSweatsScale
        rec.congestionScale = checkIn.congestionScale
        rec.feverStartAt = checkIn.feverStartAt
        rec.gpsAccuracy = checkIn.gpsAccuracy
        rec.gpsLatitude = checkIn.gpsLatitude
        rec.gpsLongitude = checkIn.gpsLongitude
        rec.sensitiveSkinScale = checkIn.sensitiveSkinScale
        rec.soreThroatScale = checkIn.soreThroatScale
        rec.temperature = checkIn.temperature

        val potentialUserToken = db.selectFrom(
            USER_TOKEN
        ).where(USER_TOKEN.TOKEN.eq(checkIn.token))
            .fetchAny()

        if(potentialUserToken == null){
            val user = db.newRecord(USER)
            user.store()
            rec.userId = user.userId
            val newTokenRecord = db.newRecord(USER_TOKEN)
            newTokenRecord.token = checkIn.token
            newTokenRecord.userId = user.userId
            newTokenRecord.store()
        }else{
            rec.userId = potentialUserToken.userId
        }


        return ApiResult()
    }
}
