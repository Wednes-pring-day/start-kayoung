package com.spring.wednes.startky.service

import com.spring.wednes.startky.domain.Member
import com.spring.wednes.startky.repository.MemberRepository

class MemberService(private val memberRepository: MemberRepository) {

    fun join(member: Member): Member {
        val alreadyUser: Member? = memberRepository.findByName(member.name)
        if (alreadyUser != null) {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
        return memberRepository.save(member)
    }

    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    fun findMemberById(id: Long): Member? {
        return memberRepository.findById(id)
    }

    fun findMemberByName(name: String): Member? {
        return memberRepository.findByName(name)
    }
}