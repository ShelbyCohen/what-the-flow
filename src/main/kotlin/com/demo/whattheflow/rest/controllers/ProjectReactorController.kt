package com.demo.whattheflow.rest.controllers

import com.demo.whattheflow.models.ProjectReactorResponse
import com.demo.whattheflow.rest.services.ProjectReactorService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("api/v1")
class ProjectReactorController(@Autowired private val projectReactorService: ProjectReactorService) {
    private val logger = LoggerFactory.getLogger(ProjectReactorController::class.java)

    @GetMapping("/reactorVenues", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllVenueNames(): Flux<List<ProjectReactorResponse>> {
        logger.info("Getting all venue names with Project Reactor ")

        return projectReactorService.getAllVenueNames()
    }

    @GetMapping("/reactorConcertVenues", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllConcertVenueNames(): Flux<List<ProjectReactorResponse>> {
        logger.info("Getting all concert venue names with Project Reactor ")

        return projectReactorService.getAllConcertVenueNames()
    }
}