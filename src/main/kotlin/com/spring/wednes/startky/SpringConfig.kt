package com.spring.wednes.startky

import com.spring.wednes.startky.repository.JdbcTemplateMemberRepository
import com.spring.wednes.startky.repository.JpaMemoryRepository
import com.spring.wednes.startky.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.sql.DataSource

@Configuration
class SpringConfig(@Autowired
                   val entityManager: EntityManager) {
    @Bean
    fun memoryMemberRepository(): MemberRepository {
//        return JdbcTemplateMemberRepository(dataSource)
        return JpaMemoryRepository(entityManager)
    }
}