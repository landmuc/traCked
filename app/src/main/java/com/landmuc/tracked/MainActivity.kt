package com.landmuc.tracked

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.landmuc.core.domain.preferences.Preferences
import com.landmuc.tracked.navigation.Navigation
import com.landmuc.tracked.ui.theme.TraCkedTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowQuestionnaire = preferences.loadShouldShowQuestionnaire()
        setContent {
            TraCkedTheme {

                Navigation(shouldShowQuestionnaire = shouldShowQuestionnaire)

            }
        }
    }
}
