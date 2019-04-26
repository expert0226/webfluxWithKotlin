package com.heaven.webflux.lesson

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient

@DisplayName("Router Test without Netty")
internal class LessonRouterWithoutWASTest {
    @DisplayName("경로 테스트: /")
    @Test
    fun lessonRoute() {
        val routeFunction= LessonRouter()
                .lessonRoute()

        val webTestClient = WebTestClient
                .bindToRouterFunction(routeFunction)
                .build()

        webTestClient.get()
                .uri("/")
                .exchange()
                .expectStatus()
                .isOk
    }
}