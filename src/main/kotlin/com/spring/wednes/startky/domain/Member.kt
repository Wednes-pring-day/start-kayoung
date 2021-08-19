package com.spring.wednes.startky.domain

import javax.persistence.*

@Entity
@Table(name="member")
class Member(
        @Column(nullable = false)
        var name: String
) {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
}

