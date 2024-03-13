package com.yohwan.lab.post

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
    private val postService: PostService,
    private val postFacade: PostFacade
) {
    @GetMapping("/posts")
    fun listPosts() = postService.listPosts()

    @GetMapping("/posts/{postId}")
    fun getPost(@PathVariable postId: Long) = postService.getPost(postId)

    @PostMapping("/posts")
    fun savePost() = postFacade.savePost()
}