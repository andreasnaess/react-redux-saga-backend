package no.computable.reactreduxsagabackend.controller

import no.computable.reactreduxsagabackend.dto.UserDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/api")
class UserController(
    private val restTemplate: RestTemplate
) {
    @GetMapping("/users")
    fun users() = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", Array<UserDTO>::class.java)
}