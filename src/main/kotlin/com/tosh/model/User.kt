package com.tosh.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "usery")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "name", nullable = false, unique = true)
    val name: @NotNull String? = null
)