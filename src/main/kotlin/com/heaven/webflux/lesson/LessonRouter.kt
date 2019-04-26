package com.heaven.webflux.lesson

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.router

@Configuration
class LessonRouter(private val lessonHandler: LessonHandler) {
    @Bean
    fun lessonRoute() = router {
        "/".nest {
            GET("/") { ok().body(fromObject("Hello Router!!!"))}
            GET("/sayHello", lessonHandler::sayHello)
            GET("/sayLove", lessonHandler::sayLove)
        }
    }
}