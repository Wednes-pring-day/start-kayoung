package com.spring.wednes.startky.domain.member

import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface MemberConverter {
    @Mappings
    fun toMemberVo(member: Member): MemberVo
}