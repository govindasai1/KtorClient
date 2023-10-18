package com.example.testDatabase

import org.jetbrains.exposed.sql.Database

object H2database {
    val url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;"
    val driver = "org.h2.Driver"
    fun init():Database{
        return Database.connect(url, driver)
    }
}