package com.spring.wednes.startky

import com.spring.wednes.startky.repository.JdbcTemplateMemberRepository
import com.spring.wednes.startky.repository.MemberRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class SpringConfig(val dataSource: DataSource) {
    @Bean
    fun memoryMemberRepository(): MemberRepository {
        return JdbcTemplateMemberRepository(dataSource)
    }
}