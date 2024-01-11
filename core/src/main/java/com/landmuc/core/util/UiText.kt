package com.landmuc.core.util

import android.content.Context

// helper class to use string resources in the view model without the need of context
// which the view model cannot provide
sealed class UiText {
    data class DynamicString(val text: String): UiText()
    data class StringResource(val resId: Int): UiText()

    // unwrap StringResource with this fun in the ui layer where we have access to the context
    fun asString(context: Context): String {
        return when(this) {
            is DynamicString -> text
            is StringResource -> context.getString(resId)
        }
    }
}