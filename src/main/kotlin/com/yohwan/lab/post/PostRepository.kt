package com.yohwan.lab.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PostRepository : JpaRepository<Post, Long> {
    fun findByTitle(title: String): Post?

    @Query("select p from Post p where p.id = :postId")
    fun findByPostId(@Param("postId") id: Long): Post?
}