package com.kotlin.springboot.nextj2ee.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/view")
class TemplateViewRouter {

    @GetMapping("/article/list")
    fun articleListView(): String {
        return "/article/list"
    }

}
