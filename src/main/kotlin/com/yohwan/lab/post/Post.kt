package com.yohwan.lab.post

import com.yohwan.lab.common.BaseEntity
import jakarta.persistence.Entity

@Entity
class Post (
    val title: String,
    val content: String,
    val subTitle: String
) : BaseEntity()