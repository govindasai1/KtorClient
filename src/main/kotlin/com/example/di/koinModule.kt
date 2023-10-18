package com.example.di

import com.example.productsDao.ProductsDao
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import com.example.repository.ProductsDaoImp
import com.example.services.ProductServices


val koinModule = module {

    singleOf(::ProductsDaoImp){bind<ProductsDao>()}
    singleOf(::ProductServices)

//    single<BankingDao> {BankingDaoImp()}
//    single { BankingServices() }
}