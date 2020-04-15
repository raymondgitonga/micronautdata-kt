package com.tosh.repository

import com.tosh.model.User
import io.micronaut.runtime.ApplicationConfiguration
import io.micronaut.spring.tx.annotation.Transactional
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class UserRepositoryImpl(@PersistenceContext private val entityManager: EntityManager, private val applicationConfiguration: ApplicationConfiguration? = null): UserRepository{


    @Transactional
    override fun save(name: String): User {
        val user = User(null, name)

        entityManager.persist(user)

        return user
    }

    @Transactional
    override fun findById(id: Long): User {

        return entityManager.find(User::class.java, id)

    }


}