package com.abdulkadirkara.paparauiclonecompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.CustomTopAppBar

@Preview(showSystemUi = true)
@Composable
fun ScreenHome(){
    Scaffold(
        topBar = {
            CustomTopAppBar()
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
                .fillMaxSize()
                .background(Color.White),
        ) {

        }
    }
}