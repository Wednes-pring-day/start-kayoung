package com.spring.wednes.startky.service

import com.spring.wednes.startky.domain.Member
import com.spring.wednes.startky.repository.MemberRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.IllegalStateException
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest(
    @Autowired val memberService: MemberService,
    @Autowired val memberRepository: MemberRepository
) {
    @Test
    fun 회원가입() {
        val name = "spring1"
        val member: Member = memberService.join(Member(null, name))
        assertThat(member.name).isEqualTo(name)
    }

        @Test
        fun `중복된 이름은 예외를 던져야한다`() {
            // given
            val name = "spring1"
            memberService.join(Member(null, name))

            // when & then
            val e: IllegalStateException = assertThrows(IllegalStateException::class.java) {
                memberService.join(Member(null, name))
            }
            assertThat(e.message).isEqualTo("이미 존재하는 회원입니다.")
        }

    @Test
    fun findMembers() {
        memberService.join(Member(null, "spring1"))
        memberService.join(Member(null, "spring2"))
        val result: List<Member> = memberService.findMembers()
        assertThat(result.size).isEqualTo(2)
    }

    @Test
    fun findMemberById() {
        val member: Member = memberService.join(Member(null, "spring1"))
        val result = memberService.findMemberById(member.id!!)
        assertThat(result?.name).isEqualTo(member.name)
    }

    @Test
    fun findMemberByName() {
        val member: Member = memberService.join(Member(null, "spring1"))
        val result = memberService.findMemberByName(member.name)
        assertThat(result?.name).isEqualTo(member.name)
    }
}