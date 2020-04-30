package com.demo.whattheflow.rest.services

import com.demo.whattheflow.rest.utils.CustomException
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.time.Duration

/**
 * Examples in this test file are kotlin version / variations from:
 *  - https://blog.knoldus.com/reactive-java-handling-errors-in-reactive-streams/
 */
class ErrorHandlingTest {

    /**
     * 1. Simply Catch the error (onErrorResume)
     */
    @Test
    fun fluxErrorHandling() {
        val stringFlux = Flux.just("a", "b", "c")
                .concatWith(Flux.error(RuntimeException("Exception Occurred")))
                .concatWith(Flux.just("D"))
                .onErrorResume { e: Throwable? ->  // on error this block gets executed - we are returning a flux on error value
                    println(e) // if you care about the Throwable use onErrorResume
                    Flux.just("default") // you can return anything here, can switch back to success stream
                }

        StepVerifier.create(stringFlux.log())
                .expectSubscription()
                .expectNext("a", "b", "c")
                .expectNext("default")
                .expectComplete()
                .verify()
    }

    /**
     * 2. Catch the error and return static value using onErrorReturn()
     */
    @Test
    fun fluxErrorHandling_onErrorReturn() {
        val stringFlux = Flux.just("a", "b", "c")
                .concatWith(Flux.error(RuntimeException("Exception Occurred")))
                .concatWith(Flux.just("D"))
                .onErrorReturn("default") // here returning a simple string on any errors
                // we lose the type of the error here

        StepVerifier.create(stringFlux.log())
                .expectSubscription()
                .expectNext("a", "b", "c")
                .expectNext("default")
                .verifyComplete()
    }

    /**
     * 3. Catch the error and translate it to a custom exception (onErrorMap)
     */
    @Test
    fun fluxErrorHandling_onErrorMap() {
        val stringFlux = Flux.just("a", "b", "c")
                .concatWith(Flux.error(RuntimeException("Exception Occurred")))
                .concatWith(Flux.just("D"))
                .onErrorMap { e: Throwable? -> CustomException(e) } // here returning a simple string on any errors
                // allows us to take the Throwable and map it to something else

        StepVerifier.create(stringFlux.log())
                .expectSubscription()
                .expectNext("a", "b", "c")
                .expectError(CustomException::class.java)
                .verify()
    }

    /**
     * 4. Catch the error and retry the same stream for a specific number of times (retry)
     */
    @Test
    fun fluxErrorHandling_withRetry() {
        val stringFlux = Flux.just("a", "b", "c")
                .concatWith(Flux.error(RuntimeException("Exception Occurred")))
                .concatWith(Flux.just("D"))
                .onErrorMap { e: Throwable? -> CustomException(e) }
                .retry(2)

        // Retry produces same stream again
        StepVerifier.create(stringFlux.log())
                .expectSubscription()
                .expectNext("a", "b", "c")
                .expectNext("a", "b", "c")
                .expectNext("a", "b", "c")
                .expectError(CustomException::class.java)
                .verify()
    }

    /**
     * 5. Catch the error using back off along with retry (retryBackoff)
     */
    @Test
    fun fluxErrorHandling_withRetryBackoff() {
        val stringFlux = Flux.just("a", "b", "c")
                .concatWith(Flux.error(RuntimeException("Exception Occurred")))
                .concatWith(Flux.just("D"))
                .onErrorMap { e: Throwable? -> CustomException(e) }
                .retryBackoff(2, Duration.ofSeconds(5)) // when you want to perform a backoff before retry

        StepVerifier.create(stringFlux.log())
                .expectSubscription()
                .expectNext("a", "b", "c")
                .expectNext("a", "b", "c")
                .expectNext("a", "b", "c")
                .expectError(IllegalStateException::class.java)
                .verify()
    }
}