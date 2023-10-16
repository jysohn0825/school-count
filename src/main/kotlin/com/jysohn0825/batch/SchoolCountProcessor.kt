package com.jysohn0825.batch

import com.jysohn0825.core.entity.SchoolInfo
import com.jysohn0825.core.service.ExtractSchoolInfoService
import org.springframework.batch.item.ItemProcessor

class SchoolCountProcessor(
    private val extractSchoolInfoService: ExtractSchoolInfoService
) : ItemProcessor<String, SchoolInfo> {

    override fun process(item: String): SchoolInfo {
        val schoolName = extractSchoolInfoService.extractSchoolInfo(item)
        return SchoolInfo(schoolName)
    }
}
