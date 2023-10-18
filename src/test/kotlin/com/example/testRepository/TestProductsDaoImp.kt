package com.example.testRepository

import com.example.models.Message
import com.example.models.Product
import com.example.repository.ProductsDaoImp
import com.example.table.ProductTable
import com.example.testDatabase.H2database
import com.example.testParameters.category
import com.example.testParameters.name
import com.example.testParameters.product
import com.example.testParameters.updateProduct
import io.ktor.server.testing.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.sql.Connection
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestProductsDaoImp {
    private lateinit var database: Database
    val daoImpObj = ProductsDaoImp()

    @Before
    fun start(){
        database = H2database.init()
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_REPEATABLE_READ
        transaction(database) { SchemaUtils.create(ProductTable) }
    }

    @After
    fun end(){
        transaction (database){ SchemaUtils.drop(ProductTable) }
    }

    @Test
    fun testInsert() = testApplication {
        val result = daoImpObj.insert(product)
        if (result.equals(Message)) assertTrue(true)
        else assertFalse(false)
    }

    @Test
    fun testSearch() = testApplication {
            val result = daoImpObj.searchProduct(name.name)
            if (result.equals(Product)) assertTrue(true)
            else assertFalse(false)
    }

    @Test
    fun testFetch() = testApplication {
        val result = daoImpObj.fetchProduct(category.category)
        if (result.equals(Product)) assertTrue(true)
        else assertFalse(false)
    }

    @Test
    fun testUpdate() = testApplication {
        val result = daoImpObj.updateProduct(updateProduct)
        if (result.equals(Message)) assertTrue(true)
        else assertFalse(false)
    }

    @Test
    fun testDelete() = testApplication {
        val result = daoImpObj.deleteProduct(category.category)
        if (result.equals(Message)) assertTrue(true)
        else assertFalse(false)
    }
}