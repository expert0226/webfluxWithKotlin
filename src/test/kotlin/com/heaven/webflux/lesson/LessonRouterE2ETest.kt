package com.heaven.webflux.lesson

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureWebTestClient
internal class LessonRouterE2ETest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @DisplayName("나의 테스트")
    @Test
    fun sayHelloTest() {
        // Given
        val uri = "/sayHello"
        val name = "Tom"

        // When
        webTestClient
                .get()
                .uri{ uriBuilder ->
                    uriBuilder.path(uri)
                            .queryParam("name", name)
                            .build()
                }
                .exchange()
                .expectStatus()
                .isOk
                .expectBody()
                .jsonPath("$")
                .isEqualTo("Hello $name")
    }
}