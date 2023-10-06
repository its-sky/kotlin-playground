package practice.kopring.api.request

import practice.kopring.domain.Gender
import java.time.LocalDate

data class CustomerUpdateRequest(
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate,
)
