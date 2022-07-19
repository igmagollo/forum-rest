package com.exemplo.forum.service

import com.exemplo.forum.dto.NewTopicForm
import com.exemplo.forum.dto.TopicView
import com.exemplo.forum.dto.UpdateTopicForm
import com.exemplo.forum.mapper.NewTopicFormMapper
import com.exemplo.forum.mapper.TopicViewMapper
import com.exemplo.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: MutableList<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val newTopicFormMapper: NewTopicFormMapper,
) {
    private val idSeq = generateSequence(1L) { it.inc() }.iterator()
    fun list(): List<TopicView> {
        return this.topics.map { topicViewMapper.map(it) }
    }

    fun findTopic(id: Long): TopicView? {
        val topic = this.topics.find { t -> t.id == id } ?: return null
        return topicViewMapper.map(topic)
    }

    fun insert(form: NewTopicForm): TopicView? {
        var topic = newTopicFormMapper.map(form) ?: return null
        topic = topic.copy(id = idSeq.next())
        this.topics.add(topic)
        return topicViewMapper.map(topic)
    }

    fun update(id: Long, form: UpdateTopicForm): TopicView? {
        val idx = this.topics.indexOfFirst { it.id == id }
        if (idx == -1) return null
        val topic = this.topics[idx]
        val updatedTopic = topic.copy(
            title = form.title,
            message = form.message
        )
        this.topics[idx] = updatedTopic
        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val idx = this.topics.indexOfFirst { it.id == id }
        if (idx != -1) this.topics.removeAt(idx)
    }
}