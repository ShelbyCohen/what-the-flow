package com.demo.whattheflow.rest.services

import com.demo.whattheflow.models.ConcertEvent
import com.demo.whattheflow.models.Event
import com.demo.whattheflow.models.Venue
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class ProjectReactorServiceTest {
    private val seatGeekService: SeatGeekService = mock()
    private val projectReactorService = ProjectReactorService(seatGeekService)

    @Test
    fun testGetAllVenueNames() {
        val expected = listOf(
                Event(venue = Venue(name = "venue1")),
                Event(venue = Venue(name = "venue2")),
                Event(venue = Venue(name = "venue3")),
                Event(venue = Venue(name = "venue4"))
        )
        whenever(seatGeekService.getAllEvents()).thenReturn(Flux.just(expected))

        StepVerifier.create(projectReactorService.getAllVenueNames())
                .consumeNextWith { Assertions.assertEquals(expected[0].venue.name, it[0].name) }
    }

    @Test
    fun testGetAllConcertVenueNames() {
        val expected = listOf(
                ConcertEvent(venue = Venue(name = "venue1")),
                ConcertEvent(venue = Venue(name = "venue2")),
                ConcertEvent(venue = Venue(name = "venue3")),
                ConcertEvent(venue = Venue(name = "venue4"))
        )
        whenever(seatGeekService.getConcerts()).thenReturn(Flux.just(expected))

        StepVerifier.create(projectReactorService.getAllConcertVenueNames())
                .consumeNextWith { Assertions.assertEquals(expected[0].venue.name, it[0].name) }
    }
}