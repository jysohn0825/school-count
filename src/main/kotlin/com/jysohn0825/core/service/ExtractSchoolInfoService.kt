package com.jysohn0825.core.service

import com.jysohn0825.core.document.DocumentReader
import com.jysohn0825.core.document.DocumentUtils.SCHOOL_FILED
import org.springframework.stereotype.Service

@Service
class ExtractSchoolInfoService(
    private val documentReader: DocumentReader
) {

    fun extractSchoolInfo(text: String): String {
        val checkText = ExtractSchoolInfoRegexUtils.removeUnUseText(text)
        val document = documentReader.getDoc(checkText)
        return document.get(SCHOOL_FILED)
    }
}
