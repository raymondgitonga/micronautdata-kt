package com.tosh.controller

import com.tosh.model.User
import com.tosh.repository.UserRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/users")
class UserController(val userRepository: UserRepository? = null) {

    @Get("/hello")
    fun hello(): String? {
        return "Hello"
    }

    @Get("/{id}")
    fun getUserById(id: Long?): User? {
        return userRepository?.findById(id!!)
    }

    @Post("/")
    fun save(@Body userSave: UserSave): HttpResponse<User> {
        val user = userRepository!!.save(userSave.name)
        return HttpResponse
                .created(user)
    }
}