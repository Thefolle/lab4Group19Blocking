package it.polito.group19.lab4blocking.controllers

import it.polito.group19.lab4blocking.dto.ProductDTO
import it.polito.group19.lab4blocking.services.ProductServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(private val productServiceImpl: ProductServiceImpl) {

    @PostMapping("")
    fun addProduct(@RequestBody product: ProductDTO): ResponseEntity<ProductDTO>{
        return ResponseEntity.status(HttpStatus.CREATED).body(productServiceImpl.addProduct(product))
    }

    @PatchMapping("/{productID}")
    fun updateQuantity(@RequestBody quantityToAdd: Int, @PathVariable("productID") productID: Long): ResponseEntity<ProductDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(productServiceImpl.updateQuantity(productID, quantityToAdd))
    }

    @GetMapping("/{productID}")
    fun getProduct(@PathVariable("productID") productID: Long): ResponseEntity<ProductDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(productServiceImpl.getProduct(productID))
    }

    @GetMapping("")
    fun getAllProducts(): ResponseEntity<List<ProductDTO>>{
        return ResponseEntity.status(HttpStatus.OK).body(productServiceImpl.getAllProducts())
    }

    //this URL is slightly different from the Lab file (should be localhost:8080/productsByCategory?category=<category>
    @GetMapping("/byCategory")
    fun getProductsByCategory(@RequestParam("category") category: String): ResponseEntity<List<ProductDTO>>{
        return ResponseEntity.status(HttpStatus.OK).body(productServiceImpl.getProductsByCategory(category))
    }
}
