package it.polito.group19.lab4blocking.services

import it.polito.group19.lab4blocking.dto.ProductDTO

interface ProductService {

    fun addProduct(product: ProductDTO): ProductDTO

    fun updateQuantity(quantity: Int): ProductDTO

    fun getProduct(productID: Long): ProductDTO

    fun getAllProducts(): List<ProductDTO>

    fun getProductsByCategory(category: String): List<ProductDTO>
}
