package com.example.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RefreshScope
open class MessageRestController {
    @Value("\${message:Hello default}")
    internal val message: String? = null


    @RequestMapping("/message")
    open fun getMessage(): String? {
        return this.message
    }
}