package com.heaven.webflux.lesson

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.router

@Configuration
class LessonRouter {
    @Bean
    fun lessonRoute() = router {
        "/".nest {
            GET("/") { ok().body(fromObject("Hello Router!!!"))}
        }
    }
}