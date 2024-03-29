package com.exemplo.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

data class NewTopicForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 2000)
    val message: String,

    @field:NotNull
    @field:Positive
    val idCourse: Long,

    @field:NotNull
    @field:Positive
    val idAuthor: Long,
)
