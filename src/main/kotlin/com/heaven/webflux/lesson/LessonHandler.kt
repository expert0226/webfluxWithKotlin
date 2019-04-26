package com.heaven.webflux.lesson

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class LessonHandler(private val lessonService: LessonService) {
    fun sayHello(serverRequest: ServerRequest): Mono<ServerResponse> {
        val name = serverRequest.queryParam("name").orElse("No Name")

        return ok().body(fromObject("Hello $name"))
    }

    fun sayLove(serverRequest: ServerRequest): Mono<ServerResponse> {
        val name = serverRequest.queryParam("name").orElse("No Name")
        val result = lessonService.sayLove(name)

        return ok().body(result)
    }
}