package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.landmuc.core.R
import com.landmuc.core_ui.LocalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    firstProgress: Float = 0f,
    secondProgress: Float = 0f,
    thirdProgress: Float = 0f
) {
    val spacing = LocalSpacing.current
    CenterAlignedTopAppBar(
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.displayLarge
                )
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(start = spacing.spaceExtraSmall, end = spacing.spaceExtraSmall)
                ) {
                    LinearProgressIndicator(
                        progress = firstProgress,
                        modifier = Modifier.weight(0.33f)
                        )
                    LinearProgressIndicator(
                        progress = secondProgress,
                        modifier = Modifier.weight(0.33f)
                    )
                    LinearProgressIndicator(
                        progress = thirdProgress,
                        modifier = Modifier.weight(0.33f)
                        )
                }
            }
        },
        modifier = modifier
    )
}