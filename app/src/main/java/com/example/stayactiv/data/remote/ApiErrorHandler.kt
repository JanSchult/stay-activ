package com.example.stayactiv.data.remote

object ApiErrorHandler {

    fun getErrorMessage(code: Int): String {
        return when (code) {
            400 -> "Ungültige Anfrage. Bitte überprüfe deine Eingabe."
            401, 403 -> "Zugriff verweigert. Bitte überprüfe deine Berechtigungen."
            404 -> "Die angeforderten Daten wurden nicht gefunden."
            408 -> "Zeitüberschreitung. Bitte überprüfe deine Internetverbindung."
            429 -> "Zu viele Anfragen. Bitte warte einen Moment und versuche es erneut."
            500, 502, 503, 504 ->
                "Oops, auf dem Server ist etwas schiefgelaufen – bitte später nochmal versuchen."
            else -> "Unbekannter Fehler (Code $code). Bitte versuche es später erneut."
        }
    }

    fun getNetworkErrorMessage(): String {
        return "Hm, mit deiner Internetverbindung scheint etwas nicht zu stimmen."
    }

    fun getUnexpectedErrorMessage(): String {
        return "Ein unerwarteter Fehler ist aufgetreten. Bitte versuche es später erneut."
    }
}