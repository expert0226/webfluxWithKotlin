package com.heaven.webflux.lesson

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

@DisplayName("Service TDD Test")
internal class LessonServiceTDDlTest {
    @Test
    @DisplayName("sayLove TDD Test")
    fun sayLoveTDDTest() {
        // Given
        val name = "초보람보"

        // When
        val actual = LessonServiceImpl().sayLove(name)

        // Then
        val expected = "I love $name."

        StepVerifier.create(actual.log())
                .expectNext(expected)
                .expectComplete()
                .verify()
    }
}