package com.demo.whattheflow.models

data class KotlinFlowResponse(val name: String)

data class ProjectReactorResponse(val name: String)

data class SeatGeekResponse(
    val events: List<Event>,
    val in_hand: InHand,
    val meta: Meta
)

data class Event(
    val access_method: Any? = null,
    val announce_date: String? = "",
    val announcements: Announcements? = null,
    val conditional: Boolean? = false,
    val created_at: String? = "",
    val date_tbd: Boolean? = false,
    val datetime_local: String? = "",
    val datetime_tbd: Boolean? = false,
    val datetime_utc: String? = "",
    val description: String? = "",
    val enddatetime_utc: Any? = null,
    val event_promotion: Any? = null,
    val id: Int? = 0,
    val is_open: Boolean? = false,
    val links: List<Any>? = emptyList(),
    val performers: List<Performer>? = emptyList(),
    val popularity: Double? = 0.0,
    val score: Double? = 0.0,
    val short_title: String? = "",
    val stats: StatsX? = null,
    val status: String? = "",
    val taxonomies: List<TaxonomyX>? = null,
    val time_tbd: Boolean? = false,
    val title: String? = "",
    val type: String? = "",
    val url: String? = "",
    val venue: Venue,
    val visible_until_utc: String? = ""
)

class Announcements(
)

data class Performer(
    val colors: Any?,
    val divisions: Any?,
    val has_upcoming_events: Boolean,
    val home_venue_id: Any?,
    val id: Int,
    val image: Any?,
    val image_attribution: Any?,
    val image_license: Any?,
    val images: Images,
    val location: Any?,
    val name: String,
    val num_upcoming_events: Int? = 0,
    val popularity: Int,
    val primary: Boolean,
    val score: Double,
    val short_name: String,
    val slug: String,
    val stats: Stats,
    val taxonomies: List<Taxonomy>,
    val type: String,
    val url: String
)

data class Stats(
    val event_count: Int
)

data class Taxonomy(
    val document_source: DocumentSource,
    val id: Int,
    val name: String,
    val parent_id: Int?
)

data class DocumentSource(
    val generation_type: String,
    val source_type: String
)

data class StatsX(
    val average_price: Any?,
    val dq_bucket_counts: Any?,
    val highest_price: Any?,
    val listing_count: Any?,
    val lowest_price: Any?,
    val lowest_price_good_deals: Any?,
    val lowest_sg_base_price: Any?,
    val lowest_sg_base_price_good_deals: Any?,
    val median_price: Any?,
    val visible_listing_count: Any?
)

data class TaxonomyX(
    val id: Int,
    val name: String,
    val parent_id: Int?
)

data class Venue(
    val access_method: Any? = "",
    val address: String? = "",
    val capacity: Int? = 0,
    val city: String? = "",
    val country: String? = "",
    val display_location: String? = "",
    val extended_address: String? = "",
    val has_upcoming_events: Boolean? = false,
    val id: Int? = 0,
    val links: List<Any>? = emptyList(),
    val location: Location? = null,
    val metro_code: Int? = 0,
    val name: String,
    val name_v2: String? = "",
    val num_upcoming_events: Int? = 0,
    val popularity: Int?= 0 ,
    val postal_code: String? = "",
    val score: Double? = 0.0,
    val slug: String? = "",
    val state: String? = "",
    val timezone: String? = "",
    val url: String? = ""
)

data class Location(
    val lat: Double,
    val lon: Double
)

class InHand(
)

data class Meta(
    val geolocation: Any?,
    val page: Int,
    val per_page: Int,
    val took: Int,
    val total: Int
)

data class SeatGeekConcertResponse(
    val events: List<ConcertEvent>,
    val in_hand: InHand,
    val meta: Meta
)

data class ConcertEvent(
    val access_method: Any? = "",
    val announce_date: String? = "",
    val announcements: Announcements? = null,
    val conditional: Boolean? = false,
    val created_at: String? = "",
    val date_tbd: Boolean? = false,
    val datetime_local: String? = "",
    val datetime_tbd: Boolean? = false,
    val datetime_utc: String? = "",
    val description: String? = "",
    val enddatetime_utc: Any? = "",
    val event_promotion: Any? = "",
    val general_admission: Boolean? = false,
    val id: Int? = 0,
    val is_open: Boolean? = false,
    val links: List<Any>? = emptyList(),
    val performers: List<Performer>? = emptyList(),
    val popularity: Double? = 0.0,
    val score: Double? = 0.0,
    val short_title: String? = "",
    val stats: StatsX? = null,
    val status: String? = "",
    val taxonomies: List<TaxonomyX>? = null,
    val time_tbd: Boolean? = false,
    val title: String? = "",
    val type: String? = "",
    val url: String? = "",
    val venue: Venue,
    val visible_until_utc: String? = ""
)

data class Images(
    val huge: String?
)