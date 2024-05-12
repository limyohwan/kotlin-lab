package com.yohwan.lab.common


import org.apache.commons.configuration.PropertiesConfiguration
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamicConfig {
    companion object {
        const val FILE_NAME = "/Users/im-yohwan/workspace/kotlin-lab/config.properties"
    }

    @Bean
    fun propertiesConfiguration() : PropertiesConfiguration {
        val configuration = PropertiesConfiguration(FILE_NAME)
        configuration.reloadingStrategy = FileChangedReloadingStrategy()
        return configuration;
    }
}