package com.yohwan.lab.user

import kotlinx.coroutines.delay
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException
import kotlin.random.Random

@Component
class UserReader(
    private val userRepository: UserRepository
) {
    private val logger: Logger = LoggerFactory.getLogger(UserReader::class.java)

    suspend fun getAsyncUser(name: String): User {
        val time = Random.nextLong(1, 10) * 1000
        delay(time)
        logger.info("{}ms getAsyncUser 호출 현재 시간", time)
        return userRepository.findByName(name) ?: throw IllegalArgumentException("no name")
    }

    fun getUser(name: String): User {
        val time = Random.nextLong(1, 10) * 1000
        Thread.sleep(time)
        logger.info("{}ms getUser 호출 현재 시간", time)
        return userRepository.findByName(name) ?: throw IllegalArgumentException()
    }

    suspend fun getAsyncUsers(): MutableList<User> {
        val time = Random.nextLong(1, 10) * 1000
        delay(time)
        logger.info("{}ms getAsyncUsers 호출 현재 시간", time)
        return userRepository.findAll()
    }

    fun getUsers(): MutableList<User> {
        val time = Random.nextLong(1, 10) * 1000
        Thread.sleep(time)
        logger.info("{}ms getUsers 호출 현재 시간", time)
        return userRepository.findAll()
    }
}