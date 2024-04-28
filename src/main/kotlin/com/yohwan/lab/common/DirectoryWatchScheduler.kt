package com.yohwan.lab.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DirectoryWatchScheduler(
    private val directoryWatchService: DirectoryWatchService
) {
    private val logger: Logger = LoggerFactory.getLogger(DirectoryWatchScheduler::class.java)

    @Scheduled(fixedDelay = 10000)
    fun watchDirectory() {
        logger.info("start watchDirectory")
        try {
            directoryWatchService.watch()
        } catch (e: Exception) {
            logger.info("Exception : ", e)
        }
    }
}