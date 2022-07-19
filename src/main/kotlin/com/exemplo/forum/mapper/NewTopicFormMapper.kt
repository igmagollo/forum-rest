package com.exemplo.forum.mapper

import com.exemplo.forum.dto.NewTopicForm
import com.exemplo.forum.model.Topic
import com.exemplo.forum.service.CourseService
import com.exemplo.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class NewTopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
): Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        val course = this.courseService.find(t.idCourse)
        val author = this.userService.find(t.idAuthor)
        return Topic(
            title = t.title,
            message = t.message,
            course = course,
            author = author,
        )
    }
}
