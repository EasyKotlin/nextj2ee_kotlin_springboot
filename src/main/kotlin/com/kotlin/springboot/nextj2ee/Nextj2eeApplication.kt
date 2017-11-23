package com.kotlin.springboot.nextj2ee

import com.kotlin.springboot.nextj2ee.repository.ArticleRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans

@SpringBootApplication
class Nextj2eeApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {
                        val articleRepository = ref<ArticleRepository>()
                        articleRepository.save(
                                author = "Jack",
                                title = "Kotlin + SpringBoot with JPA",
                                url = "http://www.jianshu.com/p/3944fde5da90",
                                content = """Kotlin + SpringBoot, Next J2EE Development ... """
                        )

                        articleRepository.save(
                                author = "东海陈光剑",
                                title = "Spring Boot 2.0 极简教程",
                                url = "http://www.jianshu.com/p/fc24de0c585d",
                                content = """ Spring Boot 2.0 极简教程 : 第 I 部分 Spring Boot 框架基础 ... """
                        )

                    }
                }
            }
    )
        .sources(Nextj2eeApplication::class.java)
        .run(*args)


    // runApplication<Nextj2eeApplication>(*args)
}
