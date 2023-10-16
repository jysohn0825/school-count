package com.jysohn0825.core.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class SchoolInfo(
    val name: String = "",
    @Id
    val id: UUID = UUID.randomUUID()
)
