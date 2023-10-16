package com.jysohn0825.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableBatchProcessing
@Configuration
class SchoolCountJob(
    private val jobBuilderFactory: JobBuilderFactory,
    private val schoolCountStep: SchoolCountStep,
    private val schoolCountJobListener: SchoolCountJobListener
) {

    @Bean
    fun job(): Job {
        return jobBuilderFactory["SchoolCountJob"]
            .listener(schoolCountJobListener)
            .flow(schoolCountStep.step())
            .end()
            .build()
    }
}
