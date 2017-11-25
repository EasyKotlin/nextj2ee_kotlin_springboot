package com.kotlin.springboot.nextj2ee.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by Jack on 2017/5/31.
 */
@ControllerAdvice
class JsonpAdvice : AbstractJsonpResponseBodyAdvice("callback", "jsonp")
