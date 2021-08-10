package com.spring.wednes.startky.repository

import com.spring.wednes.startky.domain.Member


class MemoryMemberRepository : MemberRepository {

    var store: HashMap<Long, Member> = HashMap()
    var sequence: Long = 0L

    override fun save(member: Member): Member {
        sequence += 1
        member.id = sequence
        store.put(sequence, member)
        return member
    }

    override fun findById(id: Long): Member? {
        return store.get(id)
    }

    override fun findByName(name: String): Member? {
        val res = store.values
            .filter { member: Member -> member.name.equals(name) }
        if (res.isEmpty()) {
            return null
        }
        return res[0]
    }

    override fun findAll(): List<Member> = ArrayList(store.values)

    fun clearStore() {
        store.clear()
    }
}