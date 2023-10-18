package com.example

import com.example.diTest.KoinModuleTest
import com.example.routeTest.ProductsRouteTest
import com.example.services.ProductServicesTest
import com.example.testRepository.TestProductsDaoImp
import com.example.testRepository.clientTest.ClientTest
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(KoinModuleTest::class,ProductsRouteTest::class,ProductServicesTest::class,
    ClientTest::class,TestProductsDaoImp::class)
class TestSuites