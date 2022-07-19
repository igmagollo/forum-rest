package com.exemplo.forum.service

import com.exemplo.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    val users: MutableList<User> = ArrayList()
) {
    private val idSeq = generateSequence(1L ) { it.inc() }.iterator()

    init {
        val user = User(
            id = idSeq.next(),
            name = "Igor",
            email = "igor@mail.com"
        )

        this.users.add(user)
    }

    fun find(id: Long): User? {
        return this.users.find { it.id == id }
    }
}
