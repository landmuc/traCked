package com.landmuc.tracker_presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.landmuc.core.domain.use_case.FilterOutDigits
import com.landmuc.core.util.UiEvent
import com.landmuc.core.util.UiText
import com.landmuc.tracker_domain.use_case.TrackerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.landmuc.core.R

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val trackerUseCases: TrackerUseCases,
    private val filterOutDigits: FilterOutDigits
): ViewModel() {

    var searchState by mutableStateOf(SearchState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SearchEvent) {
        when(event) {
            is SearchEvent.OnQueryChange -> {
                searchState = searchState.copy(query = event.query)
            }
            is SearchEvent.OnSearch -> {
                executeSearch()
            }
            is SearchEvent.OnToggleTrackableFood -> {
                searchState = searchState.copy(
                    trackableFood = searchState.trackableFood.map { trackableFoodUiState ->
                        if (trackableFoodUiState.food == event.food) trackableFoodUiState.copy(isExpanded = !trackableFoodUiState.isExpanded) else trackableFoodUiState
                    }
                )
            }
            is SearchEvent.OnAmountForFoodChange -> {
                searchState = searchState.copy(
                    trackableFood = searchState.trackableFood.map { trackableFoodUiState ->
                        if (trackableFoodUiState.food == event.food) trackableFoodUiState.copy(amount = filterOutDigits(event.amount)) else trackableFoodUiState
                    }
                )
            }
            is SearchEvent.OnTrackFoodClick -> {
                trackFood(event)
            }
            is SearchEvent.OnSearchFocusChange -> {
                searchState = searchState.copy(isHintVisible = !event.isFocused && searchState.query.isBlank())
            }
        }
    }

    private fun executeSearch() {
        viewModelScope.launch {
            searchState = searchState.copy(
                isSearching = true,
                trackableFood = emptyList()
            )
            trackerUseCases
                .searchFood(searchState.query)
                .onSuccess { trackableFoods ->
                    searchState = searchState.copy(
                        trackableFood = trackableFoods.map { trackableFood ->
                            TrackableFoodUiState(food = trackableFood)
                        },
                        isSearching = false,
                        query = ""
                    )
                }
                .onFailure {
                    searchState = searchState.copy(isSearching = false)
                    _uiEvent.send(
                        UiEvent.ShowSnackbar(
                            UiText.StringResource(R.string.error_something_went_wrong)
                        )
                    )
                }
        }
    }

    private fun trackFood(event: SearchEvent.OnTrackFoodClick) {
        viewModelScope.launch {
            val uiState = searchState.trackableFood.find { it.food == event.food }
            trackerUseCases.trackFood(
                food = uiState?.food ?: return@launch,
                amount = uiState.amount.toIntOrNull() ?: return@launch,
                mealType = event.mealType,
                date = event.date
            )
            _uiEvent.send(UiEvent.NagivateUp)
        }
    }
}
