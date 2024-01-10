package com.yohwan.lab.post

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionalEventListener

@Component
class PostSaveEventListener {

    @EventListener
//    @TransactionalEventListener
//    @Async
    fun listen(event: PostSaveEvent) {
        // send mail
    }
}

class PostSaveEvent(
    val title: String,
    val content: String,
    val subTitle: String
)