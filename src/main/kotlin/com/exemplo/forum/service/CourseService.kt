package com.exemplo.forum.service

import com.exemplo.forum.exceptions.NotFoundException
import com.exemplo.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    var courses: MutableList<Course> = ArrayList(),
) {
    private val idSeq = generateSequence(1L) { it.inc() }.iterator()

    init {
        val course = Course(
            id = this.idSeq.next(),
            name = "Kotlin + Spring Boot",
            category = "Programing"
        )

        this.courses.add(course)
    }

    fun find(id: Long): Course {
        return this.courses.find { c -> c.id == id } ?: throw NotFoundException("Course not found")
    }
}
