package no.computable.reactreduxsagabackend.controller

import mu.KotlinLogging
import no.computable.reactreduxsagabackend.dto.UserDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api")
class UserController(
    private val restTemplate: RestTemplate
) {
    @GetMapping("/users")
    fun users(): ResponseEntity<Array<UserDTO>> {
        logger.info { "Henter brukere" }
        return restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", Array<UserDTO>::class.java)
    }
}