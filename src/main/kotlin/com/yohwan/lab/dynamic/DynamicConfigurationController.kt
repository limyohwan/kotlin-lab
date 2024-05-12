package com.yohwan.lab.dynamic

import org.apache.commons.configuration.PropertiesConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DynamicConfigurationController(
    private val propertiesConfiguration: PropertiesConfiguration
) {
    @GetMapping("/dynamic")
    fun getDynamicConfig() : String {
        val key = propertiesConfiguration.getString("key")
        return key
    }
}