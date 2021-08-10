package com.spring.wednes.startky.repository

import com.spring.wednes.startky.domain.Member
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import java.sql.ResultSet
import javax.sql.DataSource

class JdbcTemplateMemberRepository(dataSource: DataSource): MemberRepository {
    val jdbcTemplate = JdbcTemplate(dataSource)

    override fun save(member: Member): Member {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id")

        val parameters: HashMap<String, String> = HashMap()
        parameters.put("name", member.name)

        val key: Number = jdbcInsert.executeAndReturnKey(MapSqlParameterSource(parameters))
        return Member(key.toLong(), member.name)
    }

    override fun findAll(): List<Member> {
        return jdbcTemplate.query("select * from member", memberRowMapper())
    }

    override fun findById(id: Long): Member? {
        val result = jdbcTemplate.query("select * from member where id=?", memberRowMapper(), id)
        if (result.isEmpty()) return null
        return result[0]
    }

    override fun findByName(name: String): Member? {
        val result = jdbcTemplate.query("select * from member where name=?", memberRowMapper(), name)
        if (result.isEmpty()) return null
        return result[0]
    }

    private fun memberRowMapper(): RowMapper<Member> = RowMapper<Member> {
        rs: ResultSet, rowNum: Int -> Member(rs.getLong("id"), rs.getString("name"))
    }
}