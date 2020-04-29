package com.demo.whattheflow.rest.functionalendpoint

import com.demo.whattheflow.models.ProjectReactorResponse
import com.demo.whattheflow.rest.services.ProjectReactorService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.mock.web.reactive.function.server.MockServerRequest
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.net.URI

class ProjectReactorHandlerTest {

    private val projectReactorService: ProjectReactorService = mock()
    private val projectReactorHandler = ProjectReactorHandler(projectReactorService)

    @Test
    fun getReactorVenues() {
        val expected = listOf(
                ProjectReactorResponse(name = "venue1"),
                ProjectReactorResponse(name = "venue2"),
                ProjectReactorResponse(name = "venue3"),
                ProjectReactorResponse(name = "venue4")
        )
        val mockServerRequest: MockServerRequest = MockServerRequest.builder()
                .uri(URI.create("http://localhost"))
                .build()

        whenever(projectReactorService.getAllVenueNames()).thenReturn(Flux.just(expected))
        StepVerifier.create(projectReactorHandler.getReactorVenues(mockServerRequest))
                .consumeNextWith { Assertions.assertEquals(HttpStatus.OK, it.statusCode()) }
                .verifyComplete()

    }

    @Test
    fun getReactorConcertVenues() {
        val expected = listOf(
                ProjectReactorResponse(name = "venue1"),
                ProjectReactorResponse(name = "venue2"),
                ProjectReactorResponse(name = "venue3"),
                ProjectReactorResponse(name = "venue4")
        )
        val mockServerRequest: MockServerRequest = MockServerRequest.builder()
                .uri(URI.create("http://localhost"))
                .build()

        whenever(projectReactorService.getAllConcertVenueNames()).thenReturn(Flux.just(expected))
        StepVerifier.create(projectReactorHandler.getReactorConcertVenues(mockServerRequest))
                .consumeNextWith { Assertions.assertEquals(HttpStatus.OK, it.statusCode()) }
                .verifyComplete()
    }
}