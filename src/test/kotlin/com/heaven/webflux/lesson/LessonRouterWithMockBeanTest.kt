package com.heaven.webflux.lesson

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerResponse.ok

@WebFluxTest(LessonRouter::class)
internal class LessonRouterWithMockBeanTest {
    @MockBean
    private lateinit var mockHandler: LessonHandler

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @DisplayName("경로 테스트: /sayHello")
    @Test
    fun sayHelloTest() {
        // Given
        val uri = "/sayHello"
        val name = "Tom"

        // When
        given(mockHandler.sayHello(myAny()))
                .willReturn(ok().body(fromObject("Hello Tom")))

        // Then
        webTestClient.get()
                .uri { uriBuilder ->
                    uriBuilder.path(uri)
                            .queryParam("name", name)
                            .build()
                }
                .exchange()
                .expectStatus()
                .isOk

        Mockito.verify(mockHandler).sayHello(myAny())
    }
}

//https://medium.com/@elye.project/befriending-kotlin-and-mockito-1c2e7b0ef791
internal fun <T> myAny(): T {
    Mockito.any<T>()
    return uninitialized()
}

@Suppress("UNCHECKED_CAST")
private fun <T> uninitialized(): T = null as T