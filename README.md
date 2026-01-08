StayActiv 🌦️🏃‍♀️

StayActiv ist eine Android-App, die Nutzer dabei hilft, passende Aktivitäten basierend auf dem aktuellen Wetter zu entdecken.
Die App kombiniert Wetterdaten, einen Aktivitätenkatalog und Filter-/Sortierfunktionen, um alltagsnahe und wetterabhängige Empfehlungen anzuzeigen.

✨ Features

🌤 Aktuelles Wetter

Anzeige der aktuellen Wetterlage über die OpenWeather API

📋 Aktivitätenkatalog

Vordefinierte Aktivitäten (defaultActivities)

Speicherung und Laden aus einer lokalen Datenbank

🔽 Dropdown-Menü zum Filtern

Filter nach Aktivitätskategorie (z. B. Sport, Fun, Relax, Home …)

Filter nach empfohlener Aktivität basierend auf dem aktuellen Wetter

➕ Floating Action Button

Navigation vom ActivityScreen zum AddActivityScreen

🧠 MVVM-Architektur

Klare Trennung von UI, State und Logik

🎨 Jetpack Compose

Moderne deklarative UI

🏗 Architektur

Das Projekt folgt dem MVVM-Pattern:

UI (Compose Screens)

ActivityScreen

AddActivityScreen

ViewModel

ActivitiesViewModel

Daten

Lokale Datenbank (Room)

Default-Aktivitäten werden beim Start geladen

State Management

StateFlow / mutableStateOf
🔽 Aktivitätskategorien

Die App nutzt folgendes Enum zur Kategorisierung:

enum class ActivityCategory {
    SPORTS,
    FUN,
    RELAX,
    EDUCATION,
    TRAVEL,
    SOCIAL,
    CREATIVE,
    HOME,
    OTHER
}

Diese Kategorien werden:

im Dropdown-Menü angezeigt

zur Filterung der Aktivitäten genutzt

im ViewModel verarbeitet

🌦 Wetterbasierte Empfehlungen

Jede Aktivität kann eine empfohlene Wetterlage besitzen (recommendedWeather).
Im Dropdown-Menü kann ausgewählt werden:

Alle Aktivitäten

Nach Kategorie

Empfohlen für das aktuelle Wetter

Das ViewModel filtert die Aktivitäten dynamisch anhand:

gewählter Kategorie

aktueller Wetterbedingung


🚀 Setup & Start


Repository klonen

Projekt in Android Studio öffnen

API-Key für OpenWeather konfigurieren

App starten (Emulator oder echtes Gerät)

Beim ersten Start werden die defaultActivities automatisch in die Datenbank geladen.

🛠 Verwendete Technologien

Kotlin

Jetpack Compose

Room

StateFlow / ViewModel

OpenWeather API

Material 3

Koin 

📌 Nächste mögliche Erweiterungen

Favoriten für Aktivitäten ⭐

Mehrere Wettertage berücksichtigen

Benutzerdefinierte Aktivitäten mit Bild

Dark Mode Optimierungen

Tests (Unit & UI)

👥 Autor

Projekt im Rahmen eines Android-/Kotlin-Projekts entwickelt.
Schwerpunkt: Moderne Android-Entwicklung mit Compose & MVVM

Viel Spaß mit StayActiv 💪🌈
