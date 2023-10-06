package practice.kopring.domain

import jakarta.persistence.*

@Entity
class Address(
    @Column
    var sido: String?,
    @Column
    var siGunGu: String?,
    @Column
    var eupMyonDong: String?,
    @Column
    var postalCode: String?,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}