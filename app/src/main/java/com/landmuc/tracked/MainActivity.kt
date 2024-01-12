package com.landmuc.tracked

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.landmuc.tracked.navigation.Navigation
import com.landmuc.tracked.ui.theme.TraCkedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TraCkedTheme {

                Navigation()

            }
        }
    }
}
