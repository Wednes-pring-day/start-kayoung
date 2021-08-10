package com.spring.wednes.startky.controller

import com.spring.wednes.startky.domain.Member
import com.spring.wednes.startky.service.MemberService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

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
        memberService.join(form.name)
        return "redirect:/"
    }

    @GetMapping("/members")
    fun list(model: Model): String {
        val members: List<Member> = memberService.findMembers()
        model.addAttribute("members", members)
        return "members/list"
    }
}