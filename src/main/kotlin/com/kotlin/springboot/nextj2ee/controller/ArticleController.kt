package com.kotlin.springboot.nextj2ee.controller

import com.kotlin.springboot.nextj2ee.entity.Article
import com.kotlin.springboot.nextj2ee.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("articleController")
@RequestMapping("/article")
class ArticleController {
    @Autowired lateinit var articleRepository: ArticleRepository

    @GetMapping("/list")
    fun list(): List<Article> {
        return articleRepository.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): Article {
        return articleRepository.getOne(id)
    }
}
