package it.polito.group19.lab4blocking.controllers

import it.polito.group19.lab4blocking.dto.ProductDTO
import it.polito.group19.lab4blocking.services.ProductServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val productServiceImpl: ProductServiceImpl) {

    @PostMapping("")
    fun addProduct(@RequestBody product: ProductDTO): ResponseEntity<ProductDTO>{
        return ResponseEntity.status(HttpStatus.CREATED).body(productServiceImpl.addProduct(product))
    }
}
