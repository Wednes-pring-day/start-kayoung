package com.spring.wednes.startky.service

import com.spring.wednes.startky.domain.Member
import com.spring.wednes.startky.repository.MemberRepository
import com.spring.wednes.startky.repository.MemoryMemberRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class MemberServiceTest(
    val memberService: MemberService,
    val memberRepository: MemoryMemberRepository
) {

    @BeforeEach
    fun beforeEach() {
        memberRepository.clearStore()
    }

    @Test
    fun join() {
        // given
        var member = Member(null, "spring1")

        // when
        memberService.join(member)

        // then
        val foundMember = memberService.findMemberByName(member.name)
        Assertions.assertThat(foundMember?.name).isEqualTo(member.name)
    }

    @Test
    fun findMembers() {
        // given
        var member = Member(null, "spring1")
        var member2 = Member(null, "spring2")

        memberService.join(member)
        memberService.join(member2)

        // when
        val foundMember = memberService.findMembers()

        //then
        Assertions.assertThat(foundMember.size).isEqualTo(2)
    }

    @Test
    fun findMemberById() {
        // given
        var member = Member(null, "spring1")
        member = memberService.join(member)

        // when
        val result = memberService.findMemberById(member.id!!)

        // then
        Assertions.assertThat(result?.name).isEqualTo(member.name)
    }

    @Test
    fun findMemberByName() {
        // given
        val member = memberService.join(Member(null, "spring1"))

        // when
        val result = memberService.findMemberByName(member.name)

        // then
        Assertions.assertThat(result?.name).isEqualTo(member.name)
    }
}