package it.polito.group19.lab4blocking.services

import it.polito.group19.lab4blocking.domain.Product
import it.polito.group19.lab4blocking.dto.ProductDTO
import it.polito.group19.lab4blocking.repositories.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductServiceImpl(private val productRepository: ProductRepository): ProductService {

    override fun addProduct(product: ProductDTO): ProductDTO{
        val productEntity = Product(
                pid = null,
                name = product.name,
                category = product.category,
                price = product.price,
                quantity = product.quantity
        )
        productRepository.save(productEntity)
        return product
    }

    override fun updateQuantity(quantity: Int): ProductDTO {
        TODO("Not yet implemented")
    }

    override fun getProduct(productID: Long): ProductDTO {
        TODO("Not yet implemented")
    }

    override fun getAllProducts(): List<ProductDTO> {
        TODO("Not yet implemented")
    }

    override fun getProductsByCategory(category: String): List<ProductDTO> {
        TODO("Not yet implemented")
    }
}
