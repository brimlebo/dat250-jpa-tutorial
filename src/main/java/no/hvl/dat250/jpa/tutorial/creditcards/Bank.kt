package no.hvl.dat250.jpa.tutorial.creditcards

import jakarta.persistence.*

@Entity
data class Bank(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToMany(mappedBy = "owningBank")
    var ownedCards: Set<CreditCard> = emptySet(),

    val name: String = ""
) {
    override fun toString(): String {
        return "Bank(id=$id, name=$name)"
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}