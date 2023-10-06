package practice.kopring.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import practice.kopring.api.request.CustomerRegistrationRequest
import practice.kopring.api.request.CustomerUpdateRequest
import practice.kopring.api.response.CustomerRegistrationResponse
import practice.kopring.api.response.CustomerResponse
import practice.kopring.service.CustomerService

@RestController
class CustomerController(
    private val customerService: CustomerService,
) {

    @PostMapping("/customers")
    fun register(@RequestBody request: CustomerRegistrationRequest): ResponseEntity<CustomerRegistrationResponse> {
        val customerRegistration = customerService.register(request)

        return ResponseEntity.ok().body(CustomerRegistrationResponse.from(customerRegistration))
    }

    @GetMapping("/customers/{id}")
    fun retrieve(@PathVariable id: Long): ResponseEntity<CustomerResponse> =
        ResponseEntity.ok().body(CustomerResponse.from(customerService.retrieve(id)))

    @PatchMapping("/customers/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: CustomerUpdateRequest,
    ): ResponseEntity<CustomerResponse> =
        with(customerService.update(id, request)) {
            return ResponseEntity.ok().body(CustomerResponse.from(this))
        }
}