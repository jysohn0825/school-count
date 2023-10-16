package com.jysohn0825.core.service

object ExtractSchoolInfoRegexUtils {

    private val keywords =
        listOf("대학교", "고등학교", "중학교", "초등학교", "대학", "여대", "여고", "남고", "예고", "외고", "통상", "여중", "남중", "대", "고", "중", "초")

    private val keywordRegex = keywords.joinToString("|") { Regex.escape(it) }

    private val pattern = "($keywordRegex)(?:\\S+\\s*)*".toRegex()

    fun removeUnUseText(text: String) = text
        .replace("\n", "")
        .replace(pattern, "$1")
}
