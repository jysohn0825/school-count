package com.jysohn0825.core.document

import com.jysohn0825.core.document.DocumentUtils.INDEX_PATH
import com.jysohn0825.core.document.DocumentUtils.schoolQueryParse
import org.apache.lucene.document.Document
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.store.FSDirectory
import org.springframework.stereotype.Component
import java.nio.file.Paths

@Component
class DocumentReader {

    private val searcher = FSDirectory
        .open(Paths.get(INDEX_PATH))
        .let { DirectoryReader.open(it) }
        .let { IndexSearcher(it) }

    fun getDoc(text: String): Document {
        val docId = searcher
            .search(schoolQueryParse(text), 5)
            .scoreDocs.first()
            .doc
        return searcher.doc(docId)
    }
}
