package it.polito.group19.lab4blocking.dto

data class ProductDTO(
        val pid: Long?,
        val name: String,
        val category: String,
        var price: Float,
        var quantity: Int
)
