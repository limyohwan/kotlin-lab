package com.yohwan.lab.post

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

@Service
class PostService(
    private val postRepository: PostRepository,
    private val publisher: ApplicationEventPublisher
) {
    private val logger: Logger = LoggerFactory.getLogger(PostService::class.java)

    fun listPosts(): MutableList<Post> = postRepository.findAll()

    @Transactional(readOnly = true)
    fun getPost(postId: Long) {
        postRepository.findById(postId).orElseThrow()
        postRepository.findByPostId(postId)
    }

    @Transactional
    fun savePost(): Post {
        logger.info("transaction name: {}", TransactionSynchronizationManager.getCurrentTransactionName())

        val savedPost = postRepository.save(Post("첫글", "첫글입니다11", "잡담"))
//        publisher.publishEvent(PostSaveEvent(savedPost.id!!, savedPost.title, savedPost.content, savedPost.subTitle))
//        try {
//            publisher.publishEvent(PostSaveEvent(savedPost))
//        } catch (e : RuntimeException) {
//            println("에러발생")
//        }
//        publisher.publishEvent(PostSaveEvent(savedPost))
        return savedPost
    }

    @Transactional
    fun savePost2(): Post {
        logger.info("transaction name: {}", TransactionSynchronizationManager.getCurrentTransactionName())

        val savedPost = postRepository.save(Post("둘글", "첫둘글입니다11", "잡담"))
//        publisher.publishEvent(PostSaveEvent(savedPost.id!!, savedPost.title, savedPost.content, savedPost.subTitle))
//        try {
//            publisher.publishEvent(PostSaveEvent(savedPost))
//        } catch (e : RuntimeException) {
//            println("에러발생")
//        }
//        publisher.publishEvent(PostSaveEvent(savedPost))

        return savedPost
    }
}
