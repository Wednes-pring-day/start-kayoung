package com.spring.wednes.startky.domain

import javax.persistence.*

@Entity
class Parent(
    name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(nullable = false)
    var name: String = name


}