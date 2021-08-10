package com.spring.wednes.startky.domain

import javax.persistence.*

@Entity
@Table(name="member")
data class Member(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(nullable = false)
        var name: String
        )