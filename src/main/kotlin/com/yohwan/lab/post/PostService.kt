package com.yohwan.lab.post

class PostService(
    private val postRepository: PostRepository
) {
    fun listPosts(): MutableList<Post> = postRepository.findAll()
}
