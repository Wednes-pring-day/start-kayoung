package com.spring.wednes.startky.domain.member

import com.spring.wednes.startky.domain.Parent
import javax.persistence.*

@Entity
class Child(
    parent: Parent
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @ManyToOne
    @JoinColumn(name = "parent_id")
    var parent: Parent = parent

}