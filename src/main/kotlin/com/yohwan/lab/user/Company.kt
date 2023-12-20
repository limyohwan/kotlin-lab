package com.yohwan.lab.user

import com.yohwan.lab.common.BaseEntity
import jakarta.persistence.Entity

@Entity
class Company(
    val name: String,
    var phone: String
) : BaseEntity()