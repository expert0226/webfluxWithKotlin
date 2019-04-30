package com.heaven.webflux.lesson

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("people")
data class Person(
        @Id val name: String,
        val age: Int
)