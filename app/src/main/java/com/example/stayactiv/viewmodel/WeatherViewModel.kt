import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stayactiv.data.repository.WeatherRepository
import com.example.stayactiv.util.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.stayactiv.util.WeatherEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

class WeatherViewModel(
) : ViewModel() {
    private val repo: WeatherRepository = WeatherRepository()


    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState
init {
    loadWeather(52.520008, 13.404954)
}
    fun loadWeather(lat: Double, lon: Double) {
        _uiState.value = WeatherUiState(isLoading = true)

        viewModelScope.launch {
            val result = repo.getWeather(lat, lon)

            if (result.isSuccess) {
                val data = result.getOrNull()
                _uiState.value = WeatherUiState(
                    today = data?.today,
                    tomorrow = data?.tomorrow,
                    isLoading = false
                )
            } else {
                // Fehler kommt komplett aus dem Repository
                val message = result.exceptionOrNull()?.message ?: "Unbekannter Fehler"

                _uiState.value = WeatherUiState(
                    today = null,
                    tomorrow = null,
                    isLoading = false,
                    errorMessage = message
                )
            }
        }
    }
}

