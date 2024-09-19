package no.hvl.dat250.jpa.tutorial.creditcards

import jakarta.persistence.*

@Entity
data class CreditCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "pincode_id")
    val pincode: Pincode = Pincode(),

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null,

    @ManyToOne
    val owningBank: Bank = Bank(),

    val number: Int = 0,

    val balance: Int = 0,

    val creditLimit: Int = 0
) {
    override fun toString(): String {
        return "CreditCard(id=$id, pincode=$pincode, customer=$customer, owningBank=$owningBank, number=$number, balance=$balance, creditLimit=$creditLimit)"
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}