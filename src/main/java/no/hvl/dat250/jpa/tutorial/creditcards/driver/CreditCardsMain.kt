package no.hvl.dat250.jpa.tutorial.creditcards.driver

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence
import no.hvl.dat250.jpa.tutorial.creditcards.*

object CreditCardsMain {
    const val PERSISTENCE_UNIT_NAME: String = "jpa-tutorial"

    @JvmStatic
    fun main(args: Array<String>) {
        Persistence.createEntityManagerFactory(
            PERSISTENCE_UNIT_NAME
        ).use { factory ->
            factory.createEntityManager().use { em ->
                em.transaction.begin()
                createObjects(em)
                em.transaction.commit()
            }
        }
    }

    private fun createObjects(em: EntityManager) {
        // Customer
        val customer = Customer(name = "Max Mustermann")

        // Address
        val address = Address(street = "Inndalsveien", number = 28)
        customer.addresses = listOf(address)
        address.owners = setOf(customer)

        // Bank
        val bank = Bank(name = "Pengebank")

        // Pincode
        val pincode = Pincode(code = "123", count = 1)

        // First CreditCard
        val firstCard = CreditCard(number = 12345, balance = -5000, creditLimit = -10000, customer = customer, pincode = pincode, owningBank = bank)

        // Second CreditCard
        val secondCard = CreditCard(number = 123, balance = 1, creditLimit = 2000, customer = customer, pincode = pincode, owningBank = bank)

        // Link credit cards to the customer
        customer.creditCards = listOf(firstCard, secondCard)

        // Add the cards to the bank's ownedCards
        bank.ownedCards = setOf(firstCard, secondCard)

        em.persist(customer)
        em.persist(address)
        em.persist(bank)
        em.persist(pincode)
        em.persist(firstCard)
        em.persist(secondCard)
    }
}