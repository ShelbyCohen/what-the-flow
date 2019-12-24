package com.demo.whattheflow.rest.controllers

import com.demo.whattheflow.models.KotlinFlowResponse
import com.demo.whattheflow.rest.services.KotlinFlowService
import kotlinx.coroutines.flow.Flow
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("api/v1")
class KotlinFlowController(@Autowired private val kotlinFlowService: KotlinFlowService) {
    private val logger = LoggerFactory.getLogger(KotlinFlowController::class.java)

    @GetMapping("/kotlinFlowVenues", produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun getAllVenueNames(): Flow<List<KotlinFlowResponse>> {
        logger.info("Getting all venue names with Kotlin Flow ")

        return kotlinFlowService.getAllVenueNames()
    }

    @GetMapping("/kotlinFlowConcertVenues", produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun getAllConcertVenueNames(): Flow<List<KotlinFlowResponse>> {
        logger.info("Getting all concert venue names with Kotlin Flow ")

        return kotlinFlowService.getAllConcertVenueNames()
    }

}