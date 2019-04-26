package com.heaven.webflux.lesson

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@DisplayName("Router Test with Netty")
@SpringBootTest
@AutoConfigureWebTestClient
internal class LessonRouterWithWASTest {
    @Autowired
    private lateinit var webTestClient: WebTestClient

    @DisplayName("경로 테스트: /")
    @Test
    fun lessonRoute() {
        webTestClient.get()
                .uri("/")
                .exchange()
                .expectStatus()
                .isOk
    }
}