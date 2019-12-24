package com.demo.whattheflow.rest.services

import com.demo.whattheflow.models.ProjectReactorResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ProjectReactorService(@Autowired private val seatGeekService: SeatGeekService) {

    fun getAllVenueNames(): Flux<List<ProjectReactorResponse>> =
            seatGeekService.getAllEvents()
                    .map { eventList -> eventList.map { ProjectReactorResponse(name = it.venue.name) } }

    fun getAllConcertVenueNames(): Flux<List<ProjectReactorResponse>> =
            seatGeekService.getConcerts()
                    .map { eventList -> eventList.map { ProjectReactorResponse(name = it.venue.name) } }

}
