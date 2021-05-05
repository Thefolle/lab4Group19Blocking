package it.polito.group19.lab4blocking.repositories

import it.polito.group19.lab4blocking.domain.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: CrudRepository<Product,Long> {
    fun findByCategory(category: String): List<Product>
}
