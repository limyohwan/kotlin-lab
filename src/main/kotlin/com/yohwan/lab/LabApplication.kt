package com.yohwan.lab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class LabApplication

fun main(args: Array<String>) {
	runApplication<LabApplication>(*args)
}
