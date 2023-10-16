package com.jysohn0825.batch

import com.jysohn0825.core.entity.SchoolInfo
import com.jysohn0825.core.entity.SchoolInfoRepository
import org.springframework.batch.item.database.JpaItemWriter
import javax.persistence.EntityManagerFactory

class SchoolCountWriter(
    private val schoolInfoRepository: SchoolInfoRepository,
    entityManagerFactory: EntityManagerFactory
) : JpaItemWriter<SchoolInfo>() {

    init {
        setEntityManagerFactory(entityManagerFactory)
    }

    override fun write(items: MutableList<out SchoolInfo>) {
        schoolInfoRepository.saveAll(items)
    }
}
