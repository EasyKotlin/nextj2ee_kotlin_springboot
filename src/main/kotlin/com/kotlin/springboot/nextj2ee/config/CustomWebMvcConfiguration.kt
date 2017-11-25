package com.kotlin.springboot.nextj2ee.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import java.nio.charset.StandardCharsets


@Configuration
class CustomWebMvcConfiguration : WebMvcConfigurerAdapter() {

    @Bean
    fun responseBodyConverter(): HttpMessageConverter<String> {
        return StringHttpMessageConverter(StandardCharsets.UTF_8)
    }

    override fun configureMessageConverters(
        converters: MutableList<HttpMessageConverter<*>>) {
        super.configureMessageConverters(converters)
        converters.add(responseBodyConverter())
    }

    override fun configureContentNegotiation(
        configurer: ContentNegotiationConfigurer) {
        configurer.favorPathExtension(false)
    }
}
