package practice.kopring.service

import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import practice.kopring.api.request.CustomerRegistrationRequest
import practice.kopring.api.request.CustomerUpdateRequest
import practice.kopring.domain.Customer
import practice.kopring.repository.CustomerRepository
import practice.kopring.service.dto.CustomerDto
import practice.kopring.service.dto.CustomerRegistrationDto
import practice.kopring.util.Logger.Companion.log
import java.lang.RuntimeException

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
) {
    fun register(request: CustomerRegistrationRequest): CustomerRegistrationDto {
        val customer = Customer(
            firstName = request.firstName,
            lastName = request.lastName,
            gender = request.gender,
            birthDate = request.birthDate,
        )

        return CustomerRegistrationDto.from(customerRepository.save(customer))
            .also { log.info { "Customer Registration, id: ${customer.id}" } }
    }

    fun retrieve(id: Long): CustomerDto {
        val customer = customerRepository.findByIdOrNull(id) ?: throw RuntimeException()

        return CustomerDto.from(customer)
    }

    @Transactional
    fun update(id: Long, request: CustomerUpdateRequest): CustomerDto {
        val customer = customerRepository.findByIdOrNull(id) ?: throw RuntimeException()
        customer.update(request)

        return CustomerDto.from(customer)
    }
}