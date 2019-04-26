package com.heaven.webflux.lesson

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.springframework.web.reactive.function.server.ServerRequest
import java.util.*

@DisplayName("LessonHandler BDD Test")
internal class LessonHandlerBDDTest {
    @DisplayName("sayHello BDD Test")
    @Test
    fun sayHelloBDDTest() {
        // Given
        val mockRequest = mock(ServerRequest::class.java)

        given(mockRequest.queryParam("name"))
                .willReturn(Optional.of("초보람보"))

        // When
        val lessonHandler = LessonHandler()
        lessonHandler.sayHello(mockRequest)

        // Then
        Mockito.verify(mockRequest).queryParam("name")
    }
}