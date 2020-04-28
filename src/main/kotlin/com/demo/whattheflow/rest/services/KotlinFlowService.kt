package com.demo.whattheflow.rest.services

import com.demo.whattheflow.models.KotlinFlowResponse
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.reactive.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KotlinFlowService(@Autowired private val seatGeekService: SeatGeekService) {

    suspend fun getAllVenueNames(): Flow<List<KotlinFlowResponse>> =
            seatGeekService.getAllEvents()
                    .map { eventList -> eventList.map { KotlinFlowResponse(name = it.venue.name) } }
                    .asFlow()

    fun getAllConcertVenueNames(): Flow<List<KotlinFlowResponse>> =
            seatGeekService.getConcertsFlow()
                    .map { eventList -> eventList.map { KotlinFlowResponse(name = it.venue.name) } }

}
