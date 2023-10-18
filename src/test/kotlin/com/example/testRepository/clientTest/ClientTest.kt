package com.example.testRepository.clientTest

import com.example.models.ProductsArray
import com.example.repository.client.gettingProducts
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ClientTest {

    @Test
    fun testClient() = testApplication {
        val result = gettingProducts()
        if (result.equals(ProductsArray)) assertTrue(true)
        else assertFalse(false)
    }
}