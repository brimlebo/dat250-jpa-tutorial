package no.hvl.dat250.jpa.tutorial.creditcards

import jakarta.persistence.*

@Entity
data class Pincode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val code: String = "",

    val count: Int = 0
) {
    override fun toString(): String {
        return "Pincode(id=$id, code=$code, count=$count)"
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}