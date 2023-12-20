package com.yohwan.lab.user

import com.yohwan.lab.common.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    val name: String,
    var phone: String
) : BaseEntity() {
    var isDone: Boolean = false
}