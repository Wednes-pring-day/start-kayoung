package com.spring.wednes.startky.service

import com.spring.wednes.startky.domain.Member
import com.spring.wednes.startky.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository) {

    fun join(name: String): Member {
        val alreadyUser: Member? = memberRepository.findByName(name)
        if (alreadyUser != null) {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
        val newMember = Member(null, name)
        memberRepository.save(newMember)
        return newMember
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