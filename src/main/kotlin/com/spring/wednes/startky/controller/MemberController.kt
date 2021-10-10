package com.spring.wednes.startky.controller

import com.spring.wednes.startky.domain.member.Member
import com.spring.wednes.startky.domain.member.MemberVo
import com.spring.wednes.startky.service.MemberService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MemberController(private val memberService: MemberService) {

    @GetMapping("/")
    fun home(): String {
        return "/home"
    }

    @GetMapping("/members/new")
    fun createForm(): String {
        return "members/join-form"
    }

    @PostMapping("/members/new")
    fun create(form: MemberForm): String {
        memberService.join(Member(null, form.name))
        return "redirect:/"
    }

    @GetMapping("/members")
    fun list(model: Model): String {
        val members: List<Member> = memberService.findMembers()
        model.addAttribute("members", members)
        return "members/list"
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun read(@PathVariable(value = "id") id: Long): MemberVo = memberService.findMember(id)
}