package com.spring.wednes.startky.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Member(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
        var name: String
        )