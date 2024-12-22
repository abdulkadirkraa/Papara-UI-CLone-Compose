package com.abdulkadirkara.paparauiclonecompose.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.navigation.Navigation
import com.abdulkadirkara.paparauiclonecompose.ui.navigation.Screens

@Composable
fun BottomNavigationBar() {
    val choosenItem = remember { mutableStateOf(0) }

    val menuItems = listOf(
        BottomNavItem(R.drawable.ic_home_menu, "Ana Sayfa", Screens.ScreenHome),
        BottomNavItem(R.drawable.ic_qr_menu, "Qr İşlemleri", Screens.ScreenQrTransactions),
        BottomNavItem(R.drawable.ic_money_menu, "Para Transferi", Screens.ScreenMoneyTransfer),
        BottomNavItem(R.drawable.ic_payment_menu, "Ödemeler", Screens.ScreenPayments),
        BottomNavItem(R.drawable.ic_card_menu, "Papara Card", Screens.ScreenPaparaCard)
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                content = {
                    menuItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = false,
                            onClick = { choosenItem.value = index },
                            icon = { Image(painter = painterResource(bottomNavItem.iconRes), contentDescription = "") },
                            label = {
                                Text(
                                    fontSize = 10.sp,
                                    text = bottomNavItem.label,
                                    style = if (choosenItem.value == index) {
                                        TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
                                    } else {
                                        TextStyle(fontWeight = FontWeight.Normal, color = Color.Gray)
                                    }
                                )
                            }
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Navigation(chosenScreen = menuItems[choosenItem.value].screen.route)
        }
    }
}

data class BottomNavItem(
    val iconRes: Int,
    val label: String,
    val screen: Screens
)
