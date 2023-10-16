package com.jysohn0825.batch

import com.jysohn0825.core.document.DocumentWriter
import com.jysohn0825.core.entity.SchoolInfoRepository
import org.springframework.stereotype.Component
import javax.batch.api.listener.JobListener

@Component
class SchoolCountJobListener(
    private val schoolInfoRepository: SchoolInfoRepository
) : JobListener {
    override fun beforeJob() {
        DocumentWriter()
    }

    override fun afterJob() {
        schoolInfoRepository.findSchoolInfoGroupByName()
            .forEach {
                println(it.name + " " + it.count)
            }
    }
}
