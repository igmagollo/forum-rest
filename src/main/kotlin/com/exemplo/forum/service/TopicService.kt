package com.exemplo.forum.service

import com.exemplo.forum.model.Course
import com.exemplo.forum.model.Topic
import com.exemplo.forum.model.User
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic>,
) {
    init {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "Variaveis no Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Igor",
                email = "igor@email.com"
            )
        )

        val topic2 = Topic(
            id = 2,
            title = "Concorrencia Kotlin",
            message = "Threads em Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Igor",
                email = "igor@email.com"
            )
        )

        val topic3 = Topic(
            id = 3,
            title = "Kotlin funcional",
            message = "Funções em Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 2,
                name = "Cleito",
                email = "Cleito@email.com"
            )
        )
        this.topics =  listOf(topic, topic2, topic3)
    }

    fun list(): List<Topic> {
        return this.topics
    }

    fun findTopic(id: Long): Topic? {
        return this.topics.find { t -> t.id == id }
    }
}