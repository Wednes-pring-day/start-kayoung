package com.spring.wednes.startky.repository

import com.spring.wednes.startky.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaMemberRepository: JpaRepository<Member, Long>, MemberRepository {
    override fun findByName(name: String): Member?
}