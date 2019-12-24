package com.demo.whattheflow.rest.services

import com.demo.whattheflow.models.ConcertEvent
import com.demo.whattheflow.models.Event
import com.demo.whattheflow.models.Venue
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux

class KotlinFlowServiceTest {
    private val seatGeekService: SeatGeekService = mock()
    private val kotlinFlowService = KotlinFlowService(seatGeekService)

    @Test
    suspend fun testGetAllVenueNames() {
        val expected = listOf(
                Event(venue = Venue(name = "venue1")),
                Event(venue = Venue(name = "venue2")),
                Event(venue = Venue(name = "venue3")),
                Event(venue = Venue(name = "venue4"))
        )
        whenever(seatGeekService.getAllEvents()).thenReturn(Flux.just(expected))

        kotlinFlowService.getAllVenueNames()
                .map { Assertions.assertEquals(expected[0].venue.name, it[0].name) }
    }

    @Test
    suspend fun testGetAllConcertVenueNames() {
        val expected = listOf(
                ConcertEvent(venue = Venue(name = "venue1")),
                ConcertEvent(venue = Venue(name = "venue2")),
                ConcertEvent(venue = Venue(name = "venue3")),
                ConcertEvent(venue = Venue(name = "venue4"))
        )
        whenever(seatGeekService.getConcertsFlow()).thenReturn(flowOf(expected))

        kotlinFlowService.getAllConcertVenueNames()
                .map { Assertions.assertEquals(expected[0].venue.name, it[0].name) }
    }

}