package com.heaven.webflux.lesson

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient

@DisplayName("Router Test without Netty")
internal class LessonRouterWithoutWASTest {
    private val lessonService = LessonServiceImpl()
    private val lessonHandler = LessonHandler(lessonService)

    private val routeFunction= LessonRouter(lessonHandler)
            .lessonRoute()

    private val webTestClient = WebTestClient
            .bindToRouterFunction(routeFunction)
            .build()

    @DisplayName("경로 테스트: /")
    @Test
    fun lessonRoute() {
        // Given
        val uri = "/"

        // When

        // Then
        val expected = "Hello Router!!!"

        webTestClient.get()
                .uri(uri)
                .exchange()
                .expectStatus()
                .isOk
                .expectBody()
                .jsonPath("$")
                .isEqualTo(expected)
    }

    @DisplayName("경로 테스트: /sayHello")
    @Test
    fun sayHelloTest() {
        // Given

        // When

        // Then
        checkResult("/sayHello", "Tom", "Hello Tom")
    }

    @DisplayName("경로 테스트: /sayLove")
    @Test
    fun sayLoveTest() {
        // Given

        // When

        // Then
        checkResult("/sayLove", "Tom", "I love Tom.")
    }

    private fun checkResult(uri: String, name: String, expected: String) {
        webTestClient.get()
                .uri { uriBuilder ->
                    uriBuilder.path(uri)
                            .queryParam("name", name)
                            .build()
                }
                .exchange()
                .expectStatus()
                .isOk
                .expectBody()
                .jsonPath("$")
                .isEqualTo(expected)
    }
}