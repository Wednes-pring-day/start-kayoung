package com.spring.wednes.startky.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class TimeTrace {
    fun execute(joinPoint: ProceedingJoinPoint): Any? {
        val start: Long = System.currentTimeMillis()
        println("START: $joinPoint")
        try {
            return joinPoint.proceed()
        } finally {
            val finish: Long = System.currentTimeMillis()
            val timeMs: Long = finish - start
            println("END: $joinPoint ${timeMs}ms")
        }
    }
}