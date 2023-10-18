package com.example.routeTest

import com.example.module
import com.example.plugins.configureRouting
import com.example.testParameters.category
import com.example.testParameters.name
import com.example.testParameters.product
import com.example.testParameters.updateProduct
import com.example.utils.endPoints.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductsRouteTest {

    @Test
    fun testSearchRoute() {
        testApplication {
            application {
                module(configureRouting())
            }
            val client = createClient {
                install(ContentNegotiation) {
                    json()
                }
            }
            val responce = client.post(BASE_PATH+ SEARCH_PRODUCT) {
                headers[HttpHeaders.ContentType] = ContentType.Application.Json.toString()
                setBody(name)
            }
            assertEquals(HttpStatusCode.OK, responce.status)
        }
    }

    @Test
    fun testFetchRoute() {
        testApplication {
            application {
                module(configureRouting())
            }
            val client = createClient {
                install(ContentNegotiation) {
                    json()
                }
            }
            val responce = client.post(BASE_PATH+ FETCH_PRODUCT) {
                headers[HttpHeaders.ContentType] = ContentType.Application.Json.toString()
                setBody(category)
            }
            assertEquals(HttpStatusCode.OK, responce.status)
        }
    }

    @Test
    fun testUpdateTest() {
        testApplication {
            application {
                module(configureRouting())
            }
            val client = createClient {
                install(ContentNegotiation) {
                    json()
                }
            }
            val responce = client.post(BASE_PATH+ UPDATE_PRODUCT) {
                headers[HttpHeaders.ContentType] = ContentType.Application.Json.toString()
                setBody(updateProduct)
            }
            assertEquals(HttpStatusCode.OK, responce.status)
        }
    }


}