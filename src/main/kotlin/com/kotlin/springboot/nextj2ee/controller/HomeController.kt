package com.kotlin.springboot.nextj2ee.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HomeController {

    @GetMapping(value = *arrayOf("/"))
    fun articleListView(): String {
        return "/article/list"
    }

}
