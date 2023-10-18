package com.example.services

import com.example.di.koinModule
import com.example.models.Product
import com.example.table.ProductTable
import com.example.testDatabase.H2database
import com.example.testParameters.category
import com.example.testParameters.name
import com.example.testParameters.product
import com.example.testParameters.updateProduct
import com.example.utils.responces.successDeletion
import com.example.utils.responces.successUpdation
import io.ktor.server.testing.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import java.sql.Connection
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ProductServicesTest {
    private lateinit var database: Database
    private val serviceObj = ProductServices()

    @Before
    fun start(){
        startKoin { modules(koinModule) }
        database = H2database.init()
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_REPEATABLE_READ
        transaction(database) { SchemaUtils.create(ProductTable) }
    }

    @Test
    fun testinsert() = testApplication {
        val result = serviceObj.insertGetAllProducts()
        assertEquals(product,result[0])
    }

    @Test
    fun testSearch() = testApplication {
        val result = serviceObj.searchingProduct(name.name)
        if (result.equals(Product)) assertTrue(true)
        else assertFalse(false)
    }
    @Test
    fun testFetch() = testApplication {
        val result = serviceObj.fetchingProducts(category.category)
        if (result.equals(Product)) assertTrue(true)
        else assertFalse(false)
    }

    @Test
    fun testUpdate() = testApplication {
        val result = serviceObj.updateProduct(updateProduct)
        assertEquals(successUpdation,result)
    }

    @Test
    fun testDeletion() = testApplication {
        val result = serviceObj.deleteProduct(category.category)
        assertEquals(successDeletion,result)
    }

    @After
    fun end(){
        stopKoin()
//        transaction (database){ SchemaUtils.drop(ProductTable) }
    }



}