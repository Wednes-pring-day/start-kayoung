package com.spring.wednes.startky.repository

import com.spring.wednes.startky.domain.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test


internal class MemoryMemberRepositoryTest {
    private var repository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() {
        repository.clearStore()
    }

    @Test
    fun save() {
        val member = Member(repository.sequence++, "spring")
        val result: Member = repository.save(member)
        assertThat(result.name).isEqualTo(member.name)
    }


    @Test
    fun findById() {
        val member = Member(repository.sequence++, "spring")
        repository.save(member)
        val result: Member = repository.findById(member.id!!)!!
        assertThat(result.name).isEqualTo(member.name)
    }

    @Test
    fun findByName() {
        val member = Member(repository.sequence++, "spring")
        repository.save(member)
        val result = repository.findByName(member.name)!!
        assertThat(result.name).isEqualTo(member.name)
    }

    @Test
    fun findAll() {
        val member1 = Member(repository.sequence++, "spring1")
        val member2 = Member(repository.sequence++, "spring2")
        repository.save(member1)
        repository.save(member2)
        val result: List<Member> = repository.findAll()
        assertThat(result.size).isEqualTo(2)
    }

}