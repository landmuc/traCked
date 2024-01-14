package com.landmuc.core.domain.use_case

class FilterOutDigitsAndDots {

    operator fun invoke(text: String): String {
        return text.filter { it.toString().matches(
            Regex("\\d{0,3}(\\.\\d?)?")
        ) }
    }
}