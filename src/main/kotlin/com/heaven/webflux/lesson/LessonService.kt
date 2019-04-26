package com.heaven.webflux.lesson

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

interface LessonService {
    fun sayLove(name: String): Mono<String>
}

@Service
class LessonServiceImpl: LessonService {
    override fun sayLove(name: String): Mono<String> =
            Mono.just("I love $name.")
}