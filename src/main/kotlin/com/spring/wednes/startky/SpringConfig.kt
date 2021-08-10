package com.spring.wednes.startky


import com.spring.wednes.startky.repository.MemberRepository
import com.spring.wednes.startky.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig(@Autowired val memberRepository: MemberRepository) {
    @Bean
    fun memberService() = MemberService(memberRepository)
}