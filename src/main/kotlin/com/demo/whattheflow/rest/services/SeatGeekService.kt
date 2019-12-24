package com.demo.whattheflow.rest.services

import com.demo.whattheflow.models.ConcertEvent
import com.demo.whattheflow.models.Event
import com.demo.whattheflow.models.SeatGeekConcertResponse
import com.demo.whattheflow.models.SeatGeekResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow
import reactor.core.publisher.Flux

@Service
class SeatGeekService {

    @Value("\${seatgeek.client-id}")
    lateinit var seatgeekClientId: String

    @Value("\${seatgeek.client-secret}")
    lateinit var seatgeekSecret: String

    fun getAllEvents(): Flux<List<Event>> = WebClient
            .create("https://api.seatgeek.com/2/events")
            .get()
            .uri("?client_id=$seatgeekClientId&client_secret=$seatgeekSecret")
            .retrieve()
            .bodyToFlux(SeatGeekResponse::class.java)
            .map { it.events }

    fun getConcertsFlow(): Flow<List<ConcertEvent>> = WebClient
            .create("https://api.seatgeek.com/2/events")
            .get()
            .uri("?q=concert&client_id=$seatgeekClientId&client_secret=$seatgeekSecret")
            .retrieve()
            .bodyToFlow<SeatGeekConcertResponse>()
            .map { it.events }

    fun getConcerts(): Flux<List<ConcertEvent>> = WebClient
            .create("https://api.seatgeek.com/2/events")
            .get()
            .uri("?q=concert&client_id=$seatgeekClientId&client_secret=$seatgeekSecret")
            .retrieve()
            .bodyToFlux(SeatGeekConcertResponse::class.java)
            .map { it.events }
}