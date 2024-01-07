package com.yohwan.lab.user

import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userReader: UserReader,
    private val companyReader: CompanyReader
) {
    private val logger: Logger = LoggerFactory.getLogger(UserReader::class.java)

    fun getUsers(): MutableList<User> = userRepository.findAll()

    fun getUser(name: String): User = runBlocking { async { userReader.getAsyncUser(name) }.await() }

//    @Transactional(readOnly = true)
//    fun getUser(name: String): User {
//        val user = userReader.getUser(name)
//        Thread.sleep(500L)
//        userReader.getUser(name)
//        Thread.sleep(500L)
//        return userRepository.findByIdOrNull(user.id!!) ?: throw IllegalArgumentException()
//    }

    @Transactional
    fun saveUser(name: String, phone: String) = userRepository.save(User(name, phone))

    @Transactional
    fun updateUser(name: String, phone: String) = userReader.getUser(name)
        .apply {
            this.phone = phone
        }

    @Transactional
    fun getAsyncCustomers(name: String) = runBlocking {
        logger.info("start 시작")
        val user = async { userReader.getAsyncUser(name) }
        val users = async { userReader.getAsyncUsers() }
        val companies = async { companyReader.getAsyncCompanies() }

        // users와 companies를 합쳐 customers를 만듬
        val customers: List<Customer> = users.await().map { Customer(it.name, it.phone) }
            .plus(companies.await().map { Customer(it.name, it.phone) })

        // user에 상태를 바꿈
        user.await().apply {
            this.isDone = true
        }

        customers
    }

//    @Transactional
//    fun getAsyncCustomers(name: String) = runBlocking {
//        logger.info("start 시작")
//        withContext(Executors.newFixedThreadPool(3).asCoroutineDispatcher()) {
//            val user = async { userReader.getUser(name) }
//            val users = async { userReader.getUsers() }
//            val companies = async { companyReader.getCompanies() }
//
//            // users와 companies를 합쳐 customers를 만듬
//            val customers: List<Customer> = users.await().map { Customer(it.name, it.phone) }
//                .plus(companies.await().map { Customer(it.name, it.phone) })
//
//            // user에 상태를 바꿈
//            userRepository.save(
//                user.await().apply {
//                    this.isDone = true
//                }
//            )
//
//            customers
//        }
//    }

    @Transactional
    fun getCustomers(name: String): List<Customer> {
        logger.info("start 시작")
        val user = userReader.getUser(name)
        val users = userReader.getUsers()
        val companies = companyReader.getCompanies()

        // users와 companies를 합쳐 customers를 만듬
        val customers: List<Customer> = users.map { Customer(it.name, it.phone) }
            .plus(companies.map { Customer(it.name, it.phone) })


        // user에 상태를 바꿈
        user.apply {
            this.isDone = true
        }

        return customers
    }

}

class Customer(
    val name: String,
    val phone: String
)