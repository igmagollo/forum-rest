package com.exemplo.forum.controller

import com.exemplo.forum.model.Course
import com.exemplo.forum.model.Topic
import com.exemplo.forum.model.User
import com.exemplo.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService
) {

    @GetMapping
    fun list(): List<Topic> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findTopic(@PathVariable id: Long): Topic? {
        return service.findTopic(id)
    }
}