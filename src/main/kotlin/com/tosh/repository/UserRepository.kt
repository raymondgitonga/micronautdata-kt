package com.tosh.repository

import com.tosh.model.User
interface UserRepository {

    fun save(name:  String): User
    fun findById(id:  Long): User
}