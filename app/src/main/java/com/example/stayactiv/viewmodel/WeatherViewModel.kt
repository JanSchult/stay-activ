package com.example.stayactiv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stayactiv.data.repository.WeatherRepository
import com.example.stayactiv.util.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    /**
     * Lädt Wetterdaten für die angegebenen Koordinaten
     */
    fun loadWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            repository.getWeather(latitude, longitude)
                .catch { e ->
                    _uiState.update { it.copy(isLoading = false, errorMessage = e.message) }
                }
                .collect { (today, tomorrow) ->
                    _uiState.update {
                        it.copy(
                            today = today,
                            tomorrow = tomorrow,
                            isLoading = false,
                            errorMessage = null
                        )
                    }
                }
        }
    }
}