package com.example.exception

import io.ktor.http.*

class ErrorException(val errorResponce:String,val statusCode: HttpStatusCode):RuntimeException()