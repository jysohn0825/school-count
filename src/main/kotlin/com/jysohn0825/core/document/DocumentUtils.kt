package com.jysohn0825.core.document

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.Query
import java.nio.file.Path
import java.nio.file.Paths

object DocumentUtils {
    const val SOURCE_PATH = "/Users/jyson/Develop/school-count/all_school_info.csv"
    const val INDEX_PATH = "/Users/jyson/Develop/school-count/index"

    const val SCHOOL_FILED = "school"

    private val standardAnalyzer = StandardAnalyzer()
    private val queryParser = QueryParser(SCHOOL_FILED, standardAnalyzer)

    fun schoolQueryParse(text: String): Query = queryParser.parse(text)
}
