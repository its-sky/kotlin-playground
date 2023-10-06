package practice.kopring.domain

import jakarta.persistence.*
import practice.kopring.api.request.CustomerUpdateRequest
import java.time.LocalDate
import java.time.Period

@Entity
class Customer(
    @Column
    var firstName: String,
    @Column
    var lastName: String,
    @Column
    @Enumerated(EnumType.STRING)
    var gender: Gender,
    @Column
    var birthDate: LocalDate,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    val address: Address ?=  null

    @Embedded
    val additionalInfo: AdditionalInfo ?= null

    val age: Int
        get() = Period.between(birthDate, LocalDate.now()).years

    val fullName: String
        get() = "$firstName $lastName"

    fun update(request: CustomerUpdateRequest) {
        firstName = request.firstName
        lastName = request.lastName
        gender = request.gender
        birthDate = request.birthDate
    }
}