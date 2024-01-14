package com.landmuc.core.util

// used to define all kinds of events we would like to send from our viewModel to our composables
// everything we want to show/do once in the ui which is not a state
sealed class UiEvent {
    object Success: UiEvent()
    object NagivateUp: UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
}