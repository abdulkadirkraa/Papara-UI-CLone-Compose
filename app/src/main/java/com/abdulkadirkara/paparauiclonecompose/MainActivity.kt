package com.abdulkadirkara.paparauiclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abdulkadirkara.paparauiclonecompose.ui.navigation.Navigation
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.BottomNavigationBar
import com.abdulkadirkara.paparauiclonecompose.ui.theme.PaparaUICloneComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaparaUICloneComposeTheme {
                BottomNavigationBar()
            }
        }
    }
}
