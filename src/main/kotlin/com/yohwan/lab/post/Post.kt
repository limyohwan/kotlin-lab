package com.yohwan.lab.post

import com.yohwan.lab.common.BaseEntity
import jakarta.persistence.Entity

@Entity
class Post (
    var title: String,
    var content: String,
    var subTitle: String
) : BaseEntity()