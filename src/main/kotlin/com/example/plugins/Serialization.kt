package com.example.plugins

import com.example.di.koinModule
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.plugin.Koin

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
    install(Koin){
        modules(koinModule)
    }
    routing {
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
    }
}
