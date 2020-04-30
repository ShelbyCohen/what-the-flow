package com.demo.whattheflow.rest.functionalendpoint

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class ProjectReactorRouter(private val projectReactorHandler: ProjectReactorHandler) {
    @Bean
    fun projectReactorRoutes() = router {
        ("/api/v2" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/reactorVenues", projectReactorHandler::getReactorVenues)
            GET("/reactorConcertVenues", projectReactorHandler::getReactorConcertVenues)
        }
    }
}