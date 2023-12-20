package com.yohwan.lab.user

import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/users")
    fun getUsers() = userService.getUsers()

    @GetMapping("/users/{name}")
    fun getUser(
        @PathVariable name: String
    ) = userService.getUser(name)

    @PostMapping("/users")
    fun saveUser(
        @RequestBody request: UserSaveRequest
    ) = userService.saveUser(request.name, request.phone)

    @PutMapping("/users/{name}")
    fun updateUser(
        @PathVariable name: String,
        @RequestBody request: UserUpdateRequest
    ) = userService.updateUser(name, request.phone)

    @GetMapping("/customers/async")
    fun getAsyncCustomers(
        @RequestParam username: String
    ) = userService.getAsyncCustomers(username)

    @GetMapping("/customers")
    fun getCustomers(
        @RequestParam username: String
    ) = userService.getCustomers(username)
}

class UserSaveRequest(
    val name: String,
    val phone: String
)

class UserUpdateRequest(
    val phone: String
)