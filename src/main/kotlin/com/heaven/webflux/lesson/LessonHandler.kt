package com.heaven.webflux.lesson

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class LessonHandler {
    fun sayHello(serverRequest: ServerRequest): Mono<ServerResponse> {
        val name = serverRequest.queryParam("name").orElse("No Name")

        return ok().body(fromObject("Hello $name"))
    }
}