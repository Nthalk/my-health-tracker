package com.nthalk.healthtracker.web.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "app")
data class AppConfig(
    val googleMapsApiKey: String,
    val home: String = System.getProperty("home", "./home")
)
