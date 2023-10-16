package com.jysohn0825

import com.jysohn0825.core.document.DocumentWriter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SchoolCountApplication

fun main(args: Array<String>) {
    DocumentWriter()
    runApplication<SchoolCountApplication>(*args)
}
