package com.exemplo.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UpdateTopicForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 2000)
    val message: String,
)
