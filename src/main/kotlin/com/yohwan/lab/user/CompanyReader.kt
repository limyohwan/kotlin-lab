package com.yohwan.lab.user

import kotlinx.coroutines.delay
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class CompanyReader(
    private val companyRepository: CompanyRepository
) {
    private val logger: Logger = LoggerFactory.getLogger(CompanyReader::class.java)

    suspend fun getAsyncCompanies(): MutableList<Company> {
        val time = Random.nextLong(1, 10) * 1000
        delay(10)
        logger.info("{}ms getAsyncCompanies 호출 현재 시간", time)
        return companyRepository.findAll()
    }

    fun getCompanies(): MutableList<Company> {
        val time = Random.nextLong(1, 10) * 1000
        Thread.sleep(time)
        logger.info("{}ms getCompanies 호출 현재 시간", time)
        return companyRepository.findAll()
    }
}