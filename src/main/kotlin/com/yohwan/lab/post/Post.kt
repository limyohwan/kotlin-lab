package com.yohwan.lab.post

import com.yohwan.lab.common.BaseEntity
import jakarta.persistence.Entity

@Entity
class Post (
    val name: String,
    val content: String
) : BaseEntity()