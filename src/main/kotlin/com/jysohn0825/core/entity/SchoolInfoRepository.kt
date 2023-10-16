package com.jysohn0825.core.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface SchoolInfoRepository : JpaRepository<SchoolInfo, UUID> {
    @Query(
        "SELECT si.Name As name, count(SchoolInfo) AS count FROM SchoolInfo si GROUP BY si.name",
        nativeQuery = true
    )
    fun findSchoolInfoGroupByName(): List<SchoolCount>
}
