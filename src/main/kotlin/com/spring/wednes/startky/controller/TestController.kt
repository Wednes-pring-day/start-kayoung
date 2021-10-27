package com.spring.wednes.startky.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {
    @GetMapping("")
    fun testGet(): String {
        println("왜 나는 잘 찍히지")
        return "테스트입니다"
    }
}