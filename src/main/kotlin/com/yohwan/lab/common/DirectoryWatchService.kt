package com.yohwan.lab.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.io.IOException
import java.nio.file.*
import java.nio.file.StandardWatchEventKinds.*

@Component
class DirectoryWatchService {
    private val watchService: WatchService
    private val logger: Logger = LoggerFactory.getLogger(DirectoryWatchService::class.java)

    init {
        watchService = try {
            FileSystems.getDefault().newWatchService()
        } catch (e: IOException) {
            logger.error("IOException : ", e)
            throw e
        }
    }

    fun watch() {
        val fullFilePath = "/Users/im-yohwan/Downloads"
        val dir = Paths.get(fullFilePath);

        try {
            dir.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE)

            while (true) {
               val key = watchService.take()

                for (pollEvent in key.pollEvents()) {
                    val kind = pollEvent.kind()
                    val ev: WatchEvent<Path> = pollEvent as WatchEvent<Path>
                    val filename = ev.context()

                    when (kind) {
                        OVERFLOW -> {
                            logger.info("OVERFLOW")
                        }
                        ENTRY_CREATE -> {
                            logger.info("Created: $filename");
                        }
                        ENTRY_MODIFY -> {
                            logger.info("Modified: $filename");
                        }
                        ENTRY_DELETE -> {
                            logger.info("Deleted: $filename");
                        }
                    }
                }

                val valid = key.reset()
                if (!valid) {
                    break
                }

            }
        } catch (e: IOException) {
            logger.info("IOException : ", e)
        }
    }
}