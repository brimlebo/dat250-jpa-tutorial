package no.hvl.dat250.jpa.tutorial.creditcards

import jakarta.persistence.*

@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToMany
    @JoinTable(
        name = "customer_address",
        joinColumns = [JoinColumn(name = "customer_id")],
        inverseJoinColumns = [JoinColumn(name = "address_id")]
    )
    var addresses: Collection<Address> = emptyList(),

    @OneToMany(mappedBy = "customer")
    var creditCards: Collection<CreditCard> = emptyList(),

    val name: String = ""
) {
    override fun toString(): String {
        return "Customer(id=$id, name=$name)"
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}