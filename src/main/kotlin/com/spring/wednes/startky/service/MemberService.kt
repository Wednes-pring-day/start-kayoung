package com.spring.wednes.startky.service

import com.spring.wednes.startky.domain.member.Member
import com.spring.wednes.startky.domain.member.MemberConverter
import com.spring.wednes.startky.domain.member.MemberVo
import com.spring.wednes.startky.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository, private val memberConverter: MemberConverter) {

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

    fun findMember(id: Long): MemberVo {
        val member: Member = memberRepository.findById(id) ?: throw ClassNotFoundException()
        return memberConverter.toMemberVo(member)
    }
}