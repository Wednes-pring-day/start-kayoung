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

    override fun save(name: String): Member {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id")

        val parameters: HashMap<String, String> = HashMap()
        parameters.put("name", name)

        val key: Number = jdbcInsert.executeAndReturnKey(MapSqlParameterSource(parameters))
        return Member(key.toLong(), name)
    }

    override fun findAll(): List<Member> {
        return jdbcTemplate.query("select * from member", memberRowMapper())
    }

    override fun findById(id: Long): Member? {
        val result = jdbcTemplate.query("select * from member where id=?", memberRowMapper(), id)
        if (result.size == 0) return null
        return result[0]
    }

    override fun findByName(name: String): Member? {
        val result = jdbcTemplate.query("select * from member where name=?", memberRowMapper(), name)
        if (result.size == 0) return null
        return result[0]
    }

    fun memberRowMapper(): RowMapper<Member> = RowMapper<Member> {
        rs: ResultSet, rowNum: Int -> Member(rs.getLong("id"), rs.getString("name"))
    }
}