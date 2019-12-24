package com.demo.whattheflow.rest.controllers

import com.demo.whattheflow.models.ProjectReactorResponse
import com.demo.whattheflow.rest.services.ProjectReactorService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux

class ProjectReactorControllerTest {
    private val projectReactorService: ProjectReactorService = mock()
    private val projectReactorController = ProjectReactorController(projectReactorService)

    @Test
    fun testGetAllVenueNames() {
        val expected = listOf(
                ProjectReactorResponse(name = "venue1"),
                ProjectReactorResponse(name = "venue2"),
                ProjectReactorResponse(name = "venue3"),
                ProjectReactorResponse(name = "venue4")
        )
        whenever(projectReactorService.getAllVenueNames()).thenReturn(Flux.just(expected))

        projectReactorController.getAllVenueNames()
                .map { assertEquals(expected[0].name, it[0].name) }
    }

    @Test
    fun testGetAllConcertVenueNames() {
        val expected = listOf(
                ProjectReactorResponse(name = "venue1"),
                ProjectReactorResponse(name = "venue2"),
                ProjectReactorResponse(name = "venue3"),
                ProjectReactorResponse(name = "venue4")
        )
        whenever(projectReactorService.getAllConcertVenueNames()).thenReturn(Flux.just(expected))

        projectReactorController.getAllConcertVenueNames()
                .map { assertEquals(expected[0].name, it[0].name) }
    }
}