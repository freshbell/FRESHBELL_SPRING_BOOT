package com.freshbell.myspringproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.socket.config.annotation.EnableWebSocket

@SpringBootApplication
@EnableScheduling
@EnableWebSocket
class MySpringProjectApplication

fun main(args: Array<String>) {
    runApplication<MySpringProjectApplication>(*args)
}
