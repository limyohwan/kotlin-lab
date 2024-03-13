package com.yohwan.lab.post

import org.springframework.stereotype.Component

@Component
class PostFacade(
    private val postService: PostService
) {
    fun savePost() : Post {
        val savedPost = postService.savePost()

        postService.getPost(savedPost.id!!)

        val savedPost2 = postService.savePost2()

        return savedPost2
    }
}