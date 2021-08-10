package com.spring.wednes.startky.repository

import com.spring.wednes.startky.domain.Member
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Transactional
open class JpaMemoryRepository(
    private val em: EntityManager
): MemberRepository {

    override fun save(name: String): Member {
        var member = Member(null, name)
        em.persist(member)
        return member
    }

    override fun findById(id: Long): Member? {
        return em.find(Member::class.java, id)
    }

    override fun findByName(name: String): Member? {
        val result: List<Member> = em.createQuery("select m from Member m where m.name = :name", Member::class.java)
            .setParameter("name", name)
            .resultList
        if (result.isEmpty()) return null
        return result[0]
    }

    override fun findAll(): List<Member> {
        return em.createQuery("select m from Member m", Member::class.java).resultList
    }
}