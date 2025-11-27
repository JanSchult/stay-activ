import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.util.ActivityCategory
import com.example.stayactiv.util.DifficultyLevel
import com.example.stayactiv.util.RatingCategory
import com.example.stayactiv.util.WeatherCondition
import java.util.UUID

val defaultActivities = listOf(
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Joggen im Park",
        description = "Frische Luft und Bewegung im Grünen",
        isOutdoor = true,
        recommendedWeather = listOf(WeatherCondition.SUNNY, WeatherCondition.CLOUDY),
        durationMinutes = 60,
        category = ActivityCategory.SPORTS,
        difficulty = DifficultyLevel.MEDIUM,
        isUserCreated = false,
        imageUrl = "https://example.com/images/joggen.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Indoor Klettern",
        description = "Spaßiges Klettertraining in der Halle",
        isOutdoor = false,
        recommendedWeather = listOf(WeatherCondition.ANY),
        durationMinutes = 90,
        category = ActivityCategory.SPORTS,
        difficulty = DifficultyLevel.MEDIUM,
        isUserCreated = false,
        imageUrl = "https://example.com/images/klettern.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Schwimmen im Freibad",
        description = "Abkühlung und Sport im Wasser",
        isOutdoor = true,
        recommendedWeather = listOf(WeatherCondition.SUNNY),
        durationMinutes = 60,
        category = ActivityCategory.SPORTS,
        difficulty = DifficultyLevel.EASY,
        isUserCreated = false,
        imageUrl = "https://example.com/images/schwimmen.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Museum besuchen",
        description = "Kulturelles Erlebnis, auch bei Regen",
        isOutdoor = false,
        recommendedWeather = listOf(WeatherCondition.RAINY, WeatherCondition.CLOUDY),
        durationMinutes = 120,
        category = ActivityCategory.EDUCATION,
        difficulty = DifficultyLevel.EASY,
        isUserCreated = false,
        imageUrl = "https://example.com/images/museum.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Yoga zu Hause",
        description = "Entspannung und Stretching für Körper und Geist",
        isOutdoor = false,
        recommendedWeather = listOf(WeatherCondition.ANY),
        durationMinutes = 45,
        category = ActivityCategory.RELAX,
        difficulty = DifficultyLevel.EASY,
        isUserCreated = false,
        imageUrl = "https://example.com/images/yoga.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Wandern in den Bergen",
        description = "Natur genießen und fit bleiben",
        isOutdoor = true,
        recommendedWeather = listOf(WeatherCondition.SUNNY, WeatherCondition.CLOUDY),
        durationMinutes = 180,
        category = ActivityCategory.TRAVEL,
        difficulty = DifficultyLevel.HARD,
        isUserCreated = false,
        imageUrl = "https://example.com/images/wandern.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Radtour",
        description = "Aktive Erkundung der Umgebung mit dem Fahrrad",
        isOutdoor = true,
        recommendedWeather = listOf(WeatherCondition.SUNNY, WeatherCondition.CLOUDY),
        durationMinutes = 120,
        category = ActivityCategory.SPORTS,
        difficulty = DifficultyLevel.MEDIUM,
        isUserCreated = false,
        imageUrl = "https://example.com/images/radtour.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Brettspieleabend",
        description = "Spaßige Zeit drinnen mit Freunden oder Familie",
        isOutdoor = false,
        recommendedWeather = listOf(WeatherCondition.ANY),
        durationMinutes = 120,
        category = ActivityCategory.SOCIAL,
        difficulty = DifficultyLevel.EASY,
        isUserCreated = false,
        imageUrl = "https://example.com/images/brettspiele.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Kochkurs online",
        description = "Neue Rezepte ausprobieren",
        isOutdoor = false,
        recommendedWeather = listOf(WeatherCondition.ANY),
        durationMinutes = 90,
        category = ActivityCategory.CREATIVE,
        difficulty = DifficultyLevel.MEDIUM,
        isUserCreated = false,
        imageUrl = "https://example.com/images/kochkurs.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Fototour in der Stadt",
        description = "Kreative Fotos bei schönem Wetter",
        isOutdoor = true,
        recommendedWeather = listOf(WeatherCondition.SUNNY, WeatherCondition.CLOUDY),
        durationMinutes = 120,
        category = ActivityCategory.CREATIVE,
        difficulty = DifficultyLevel.MEDIUM,
        isUserCreated = false,
        imageUrl = "https://example.com/images/fototour.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Eislaufen",
        description = "Winterspaß auf der Eisbahn",
        isOutdoor = true,
        recommendedWeather = listOf(WeatherCondition.SNOWY),
        durationMinutes = 60,
        category = ActivityCategory.FUN,
        difficulty = DifficultyLevel.MEDIUM,
        isUserCreated = false,
        imageUrl = "https://example.com/images/eislaufen.jpg",
        rating = RatingCategory.FIVE_STARS
    ),
    ActivityItem(
        id = UUID.randomUUID().toString(),
        title = "Lesezeit",
        description = "Entspanntes Lesen eines Buches",
        isOutdoor = false,
        recommendedWeather = listOf(WeatherCondition.ANY),
        durationMinutes = 60,
        category = ActivityCategory.RELAX,
        difficulty = DifficultyLevel.EASY,
        isUserCreated = false,
        imageUrl = "https://example.com/images/lesen.jpg",
        rating = RatingCategory.FIVE_STARS
    )
)
