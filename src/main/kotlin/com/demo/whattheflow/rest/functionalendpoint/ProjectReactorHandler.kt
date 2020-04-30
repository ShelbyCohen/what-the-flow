package com.demo.whattheflow.rest.functionalendpoint

import com.demo.whattheflow.models.ProjectReactorResponse
import com.demo.whattheflow.rest.controllers.ProjectReactorController
import com.demo.whattheflow.rest.services.ProjectReactorService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ProjectReactorHandler(@Autowired private val projectReactorService: ProjectReactorService) {
    private val logger = LoggerFactory.getLogger(ProjectReactorController::class.java)

    fun getReactorVenues(request: ServerRequest): Mono<ServerResponse> {
        logger.info("Getting all venue names with Project Reactor ")
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .body(projectReactorService.getAllVenueNames(), ProjectReactorResponse::class.java)
    }

    fun getReactorConcertVenues(request: ServerRequest): Mono<ServerResponse> {
        logger.info("Getting all concert venue names with Project Reactor ")

        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .body(projectReactorService.getAllConcertVenueNames(), ProjectReactorResponse::class.java)
    }
}