package com.kotlin.springboot.nextj2ee.repository

import com.kotlin.springboot.nextj2ee.entity.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional


interface ArticleRepository : JpaRepository<Article, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = """
            INSERT INTO article( title,  url,  author,  content,  gmt_create, gmt_modify)
                        VALUES (:title, :url, :author, :content, now(),      now()     )
            on duplicate key update title = :title, author = :author, content = :content, gmt_modify = now()
            """)
    fun save(
        @Param("title") title: String,
        @Param("url") url: String,
        @Param("author") author: String,
        @Param("content") content: String
    ): Int
}
