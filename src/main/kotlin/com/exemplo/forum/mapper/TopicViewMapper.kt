package com.exemplo.forum.mapper

import com.exemplo.forum.dto.TopicView
import com.exemplo.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id ?: throw Error("Internal server error"),
            title = t.title,
            message =  t.message,
            status = t.status,
            createdAt = t.createdAt
        )
    }
}