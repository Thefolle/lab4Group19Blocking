package it.polito.group19.lab4blocking.services

import it.polito.group19.lab4blocking.domain.Product
import it.polito.group19.lab4blocking.dto.ProductDTO
import it.polito.group19.lab4blocking.repositories.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
@Transactional
class ProductServiceImpl(private val productRepository: ProductRepository): ProductService {

    private fun findProductById(productID: Long): Product{
        val productOptional = productRepository.findById(productID)
        if (productOptional.isEmpty) throw ResponseStatusException(HttpStatus.NOT_FOUND, "No product with $productID found!")
        return productOptional.get()
    }

    override fun addProduct(product: ProductDTO): ProductDTO{
        val productEntity = Product(
                pid = null,
                name = product.name,
                category = product.category,
                price = product.price,
                quantity = product.quantity
        )
        return productRepository.save(productEntity).toDTO()
    }

    override fun updateQuantity(productID: Long, quantityToAdd: Int): ProductDTO {
        val product = findProductById(productID)
        if (product.quantity + quantityToAdd < 0) throw ResponseStatusException(HttpStatus.FORBIDDEN, "Insufficient stored quantity!")
        product.addQuantity(quantityToAdd)
        return product.toDTO()
    }

    override fun getProduct(productID: Long): ProductDTO {
        return findProductById(productID).toDTO()
    }

    override fun getAllProducts(): List<ProductDTO> {
        return productRepository.findAll().map { it.toDTO() }
    }

    override fun getProductsByCategory(category: String): List<ProductDTO> {
        return productRepository.findByCategory(category).map { it.toDTO() }
    }
}
