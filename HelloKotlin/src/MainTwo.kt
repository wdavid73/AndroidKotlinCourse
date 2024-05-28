enum class Daypart {
    MORNING, AFTERNOON, EVENING
}
class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)

val Event.durationOffEvent: String
    get() = if(this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45),
    )

    val eventsShort = events.filter {
        it.durationInMinutes < 60
    }

    println("Tienes ${eventsShort.size} eventos cortos")

    println()

    val eventsByDaypart = events.groupBy { it.daypart }
    eventsByDaypart.forEach{
        (daypart, events) -> println("$daypart: ${events.size} events")
    }
    println()

    println("Last event of the day: ${events.last().title}")

    println()

    println(events[0].durationOffEvent)

}