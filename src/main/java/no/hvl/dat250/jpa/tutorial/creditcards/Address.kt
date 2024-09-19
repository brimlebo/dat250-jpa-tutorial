package no.hvl.dat250.jpa.tutorial.creditcards

import jakarta.persistence.*

@Entity
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToMany(mappedBy = "addresses")
    var owners: Set<Customer> = emptySet(),

    val street: String = "",

    val number: Int = 0
) {
    override fun toString(): String {
        return "Address(id=$id, street=$street, number=$number)"
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}