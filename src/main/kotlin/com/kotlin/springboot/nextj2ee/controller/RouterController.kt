package com.kotlin.springboot.nextj2ee.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/view")
class RouterController {

    @GetMapping(value = *arrayOf("/", "/article/", "/article/list"))
    fun articleListView(): String {
        return "/article/list"
    }

    @GetMapping("/article/{id}")
    fun articleDetailView(@PathVariable("id") id: Long, model: Model): String {
        model.addAttribute("id", id)
        return "/article/detail"
    }
    @GetMapping("/article/add")
    fun articleDetailView(): String {
        return "/article/add"
    }

}
