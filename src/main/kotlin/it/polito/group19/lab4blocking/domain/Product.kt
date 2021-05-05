package it.polito.group19.lab4blocking.domain

import it.polito.group19.lab4blocking.dto.ProductDTO
import javax.persistence.*

@Entity
class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var pid: Long?,
        var name: String,
        var category: String,
        var price: Float,
        var quantity: Int
) {

        fun addQuantity(quantityToAdd: Int): Int{
                quantity += quantityToAdd
                return quantity
        }

        fun toDTO() = ProductDTO(
                pid = pid!!,
                name = this.name ?: "",
                category = this.category ?: "",
                price = price ?: 0F,
                quantity = quantity ?: 0
                )
}
