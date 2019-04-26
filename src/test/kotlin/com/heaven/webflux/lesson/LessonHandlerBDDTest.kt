package com.heaven.webflux.lesson

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.springframework.web.reactive.function.server.ServerRequest
import reactor.core.publisher.Mono
import java.util.*

@DisplayName("LessonHandler BDD Test")
internal class LessonHandlerBDDTest {
    private val paramName = "name"
    private val name = "초보람보"

    private val mockRequest = mock(ServerRequest::class.java)
    private val mockService = mock(LessonService::class.java)
    private val lessonHandler = LessonHandler(mockService)

    @BeforeEach
    fun setUp() {
        given(mockRequest.queryParam(paramName))
                .willReturn(Optional.of(name))

    }

    @DisplayName("sayHello BDD Test")
    @Test
    fun sayHelloBDDTest() {
        // Given

        // When
        lessonHandler.sayHello(mockRequest)

        // Then
        Mockito.verify(mockRequest)
                .queryParam(paramName)
    }

    @DisplayName("sayLove BDD Test")
    @Test
    fun sayLoveBDDTest() {
        // Given
        given(mockService.sayLove(name))
                .willReturn(Mono.just("I love $name."))

        // When
        lessonHandler.sayLove(mockRequest)

        // Then
        Mockito.verify(mockService)
                .sayLove(name)
    }
}