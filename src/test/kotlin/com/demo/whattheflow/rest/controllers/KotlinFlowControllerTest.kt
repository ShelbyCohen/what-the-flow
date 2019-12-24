package com.demo.whattheflow.rest.controllers

import com.demo.whattheflow.models.KotlinFlowResponse
import com.demo.whattheflow.rest.services.KotlinFlowService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinFlowControllerTest {
    private val kotlinFlowService: KotlinFlowService = mock()
    private val kotlinFlowController = KotlinFlowController(kotlinFlowService)

    @Test
    suspend fun testGetAllVenueNames() {
        val expected = listOf(
                KotlinFlowResponse(name = "venue1"),
                KotlinFlowResponse(name = "venue2"),
                KotlinFlowResponse(name = "venue3"),
                KotlinFlowResponse(name = "venue4")
        )
        whenever(kotlinFlowService.getAllVenueNames()).thenReturn(flowOf(expected))

        kotlinFlowController.getAllVenueNames()
                .map { assertEquals(expected[0].name, it[0].name) }
    }

    @Test
    suspend fun testGetAllConcertVenueNames() {
        val expected = listOf(
                KotlinFlowResponse(name = "venue1"),
                KotlinFlowResponse(name = "venue2"),
                KotlinFlowResponse(name = "venue3"),
                KotlinFlowResponse(name = "venue4")
        )
        whenever(kotlinFlowService.getAllConcertVenueNames()).thenReturn(flowOf(expected))

        kotlinFlowController.getAllConcertVenueNames()
                .map { assertEquals(expected[0].name, it[0].name) }
    }
}