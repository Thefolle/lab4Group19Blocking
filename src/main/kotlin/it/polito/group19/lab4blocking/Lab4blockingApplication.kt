package it.polito.group19.lab4blocking

import it.polito.group19.lab4blocking.domain.Product
import it.polito.group19.lab4blocking.repositories.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Lab4blockingApplication {

    @Bean
    fun fillDB(productRepository: ProductRepository): CommandLineRunner {
        return CommandLineRunner {

            val products = mutableListOf<Product>(
                Product(null, "lentils", "Legume", 1.00F, 130),
                Product(null, "Chickpeas", "Legume", 1.3F, 40),
                Product(null, "Pumpkin seeds", "Dried fruit", 2.5F, 40),
                Product(null, "Strawberry", "Fruit", 0.5F, 40),
                Product(null, "Provola", "Cheese", 4.3F, 70),
                Product(null, "Ham", "Cold cuts", 3.2F, 20),
                Product(null, "Coke", "Soda", 2.3F, 90),
                Product(null, "Orange soda", "Soda", 2.5F, 110),
                Product(null, "Cucumber", "Vegetable", 2.0F, 50),
                Product(null, "Blueberry", "Fruit", 4.1F, 30),
                Product(null, "Citron", "Fruit", 2.3F, 40),
                Product(null, "Cherry", "Fruit", 2.4F, 50),
                Product(null, "Mango", "Fruit", 4.5F, 70),
                Product(null, "Persimmon", "Fruit", 3.0F, 50),
                Product(null, "Maple syrup", "Sweetener", 4.2F, 60),
                Product(null, "Black pepper", "Spice", 3.1F, 20),
                Product(null, "Brussels sprout", "Vegetable", 2.4F, 50),
                Product(null, "Spinach", "Vegetable", 2.4F, 70),
                Product(null, "Chicken", "Meat", 2.2F, 50),
                Product(null, "Finger", "Fish", 3.3F, 40),
                Product(null, "Cod", "Fish", 4.2F, 90),
                Product(null, "Swordfish", "Fish", 6.3F, 40),
                Product(null, "Salted cod", "Fish", 5.5F, 60),
                Product(null, "Electric ray", "Fish", 45.9F, 4),
                Product(null, "Peas", "Legume", 2.0F, 90),
                Product(null, "Pear", "Fruit", 2.6F, 100),
                Product(null, "Hake", "Fish", 3.5F, 70),
                Product(null, "Tomato", "Vegetable", 2.4F, 90),
                Product(null, "Pasta", "Pasta", 1.5F, 110),
                Product(null, "Potato", "Vegetable", 2.6F, 100),
                Product(null, "Hemp seed", "Dried fruit", 5.3F, 40),
                Product(null, "Basil", "Spice", 0.4F, 40),
                Product(null, "Parsley", "Spice", 0.3F, 80)
            )

            productRepository.saveAll(products)

        }
    }

}

fun main(args: Array<String>) {
    runApplication<Lab4blockingApplication>(*args)
}
