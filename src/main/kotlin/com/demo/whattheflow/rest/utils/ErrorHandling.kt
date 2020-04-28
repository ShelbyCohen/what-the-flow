package com.demo.whattheflow.rest.utils

import org.reactivestreams.Publisher
import reactor.core.publisher.Flux

class ErrorHandling {
    var onErrorReturn1 = Flux.just("a", "b", "c")
            .concatWith(Flux.error(RuntimeException("Exception Occurred")))
            .concatWith(Flux.just("D"))
            .onErrorReturn("default") // here returning a simple string on any errors

    val onErrorReturn: Flux<String> = Flux.just(1, 2, 0)
            .map { "100/$it = ${100 / it}" } //this triggers an error with 0
            .onErrorReturn("Divided by zero :(") // error handling example

    val onErrorMap: Flux<Any> = Flux.just("timeout")
            .flatMap { callExternalService(it) }
            .onErrorMap { original -> BusinessException("oops, SLA exceeded", original) }

    var onErrorResume = Flux.just("a", "b", "c")
            .concatWith(Flux.error(RuntimeException("Exception Occurred")))
            .concatWith(Flux.just("D"))
            .onErrorResume { e: Throwable? ->  // on error this block gets executed - we are returning a flux on error value
                println(e)
                Flux.just("default")
            }

    var retry = Flux.just("a", "b", "c")
            .concatWith(Flux.error(RuntimeException("Exception Occurred")))
            .concatWith(Flux.just("D"))
            .onErrorMap { e: Throwable? -> CustomException(e) }
            .retry(2)
}







private fun callExternalService(s: String?): Publisher<out Any> {
    TODO("Not yet implemented")
}

class CustomException(e: Throwable?) : Throwable() {}
class BusinessException(s: String, original: Throwable?) : Throwable() {}
