package com.jysohn0825.core.document

import com.jysohn0825.core.document.DocumentUtils.INDEX_PATH
import com.jysohn0825.core.document.DocumentUtils.SCHOOL_FILED
import com.jysohn0825.core.document.DocumentUtils.SOURCE_PATH
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.store.FSDirectory
import java.io.File
import java.nio.file.Paths

class DocumentWriter {

    init {
        val bufferedReader = File(SOURCE_PATH).bufferedReader()
        val indexWriter = makeIndexWriter()
        indexWriter.deleteAll()
        bufferedReader.forEachLine {
            indexWriter.addDocument(createDoc(it))
        }
        indexWriter.commit()
        indexWriter.close()
    }

    private fun createDoc(schoolName: String): Document = Document().apply {
        add(StringField(SCHOOL_FILED, schoolName, Field.Store.YES))
    }

    private fun makeIndexWriter(): IndexWriter {
        val dir = FSDirectory.open(Paths.get(INDEX_PATH))
        val config = IndexWriterConfig(StandardAnalyzer())
        return IndexWriter(dir, config)
    }
}
