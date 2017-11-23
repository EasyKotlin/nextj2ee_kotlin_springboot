package com.kotlin.springboot.nextj2ee.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity
class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    lateinit var author: String
    lateinit var title: String
    @Column(name = "url", unique = true, length = 250)
    lateinit var url: String
    @Lob
    lateinit var content: String

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtCreate: Date = Date()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtModify: Date = Date()

}
