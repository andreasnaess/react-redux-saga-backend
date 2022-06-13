package no.computable.reactreduxsagabackend.controller

import mu.KotlinLogging
import no.computable.reactreduxsagabackend.dto.UserDTO
import org.springframework.http.MediaType
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
    @GetMapping("/users", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun users(): List<UserDTO> {
        logger.info { "Henter brukere" }
        val users =
            restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", Array<UserDTO>::class.java)
                .body?.toList() ?: emptyList()
        logger.info { "Response=$users" }
        return users
    }
}