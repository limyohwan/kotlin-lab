package com.yohwan.lab.post

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener
import org.springframework.transaction.support.TransactionSynchronizationManager
import kotlin.jvm.optionals.getOrNull
import kotlin.math.log

@Component
class PostSaveEventListener(
    private val postRepository: PostRepository
) {
    private val logger: Logger = LoggerFactory.getLogger(PostSaveEventListener::class.java)

//    @EventListener
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
//    @Async
    fun listen(event: PostSaveEvent) {
        // send mail
//        Thread.sleep(2000)
//        val foundPost = postRepository.findById(event.post.id!!).getOrNull() ?: throw RuntimeException()
        logger.info("Transaction name : {}", TransactionSynchronizationManager.getCurrentTransactionName())
        logger.info("send mail")
        event.post.apply {
            this.content = "수정된 본문"
        }
//        throw RuntimeException()
        logger.info(event.post.content)
        postRepository.save(event.post)
    }
}

class PostSaveEvent(
//    val id: Long,
//    val title: String,
//    val content: String,
//    val subTitle: String
    val post: Post
)