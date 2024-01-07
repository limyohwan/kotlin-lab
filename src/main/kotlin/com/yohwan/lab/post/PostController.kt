package com.yohwan.lab.post

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
    private val postService: PostService
) {
    @GetMapping("/posts")
    fun listPosts() = postService.listPosts()
}