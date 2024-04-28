package com.yohwan.lab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
@EnableAsync
class LabApplication

fun main(args: Array<String>) {
	runApplication<LabApplication>(*args)
}
