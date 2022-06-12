package no.computable.reactreduxsagabackend.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RestTemplateConfig(private val restTemplateBuilder: RestTemplateBuilder) {

    @Bean
    fun restTemplate() = restTemplateBuilder.build()
}