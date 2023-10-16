package com.jysohn0825.batch

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.core.io.FileSystemResource


class SchoolCountReader : FlatFileItemReader<String>() {
    init {
        setResource(FileSystemResource("comments.csv"))
        val lineMapper: DefaultLineMapper<String> = DefaultLineMapper<String>()
        lineMapper.setLineTokenizer(DelimitedLineTokenizer())
        setLineMapper(lineMapper)
        setLinesToSkip(1)
    }
}
