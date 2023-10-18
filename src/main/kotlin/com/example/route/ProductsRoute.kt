package com.example.route

import com.example.models.Category
import com.example.models.Name
import com.example.models.Product
import com.example.services.ProductServices
import com.example.utils.endPoints.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.productRoute(){
    val service by inject<ProductServices>()

    route(BASE_PATH)
    {
        post(GET_ALL){
               call.respond(HttpStatusCode.Created,service.insertGetAllProducts())
        }

        post(SEARCH_PRODUCT){
            val request = call.receive<Name>()
            service.searchingProduct(request.name).let {
                call.respond(it)
            }
        }

        post(FETCH_PRODUCT){
            val request = call.receive<Category>()
            service.fetchingProducts(request.category).let {
                call.respond(it)
            }
        }

        post(DELETE_PRODUCT){
            val request = call.receive<Category>()
            service.deleteProduct(request.category).let {
                call.respond(it) }
        }

        post(UPDATE_PRODUCT){
                val request = call.receive<Product>()
                service.updateProduct(request).let {
                    call.respond(it)
                }
        }
    }
}