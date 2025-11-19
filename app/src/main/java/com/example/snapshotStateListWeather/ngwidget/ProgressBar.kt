package com.example.snapshotStateListWeather.ngwidget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp

/**
 * Shows a progress bar and disables the click on background items.
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ShowProgressBar(modifier: Modifier = Modifier.size(40.dp)) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(enabled = false) {}
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .align(Alignment.Center)
                .semantics {
                    testTagsAsResourceId = true
                },
            color = Color.Green
        )
    }
}

