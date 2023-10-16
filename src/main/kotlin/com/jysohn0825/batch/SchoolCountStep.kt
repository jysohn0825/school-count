package com.jysohn0825.batch

import com.jysohn0825.core.entity.SchoolInfo
import com.jysohn0825.core.entity.SchoolInfoRepository
import com.jysohn0825.core.service.ExtractSchoolInfoService
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManagerFactory

@Configuration
class SchoolCountStep(
    private val entityManagerFactory: EntityManagerFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val schoolInfoRepository: SchoolInfoRepository,
    private val extractSchoolInfoService: ExtractSchoolInfoService
) {

    fun step(): Step {
        return stepBuilderFactory["SchoolCountStep"]
            .chunk<String, SchoolInfo>(1000)
            .reader(reader())
            .processor(processor())
            .writer(writer())
            .build()
    }

    @Bean
    fun reader() = SchoolCountReader()

    @Bean
    fun processor() = SchoolCountProcessor(extractSchoolInfoService)

    @Bean
    fun writer() = SchoolCountWriter(schoolInfoRepository, entityManagerFactory)
}
