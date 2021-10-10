package com.spring.wednes.startky.domain.member

import javax.persistence.*

@Entity
@Table(name="member")
class Member(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @Column(nullable = false)
        var name: String
) {
}

