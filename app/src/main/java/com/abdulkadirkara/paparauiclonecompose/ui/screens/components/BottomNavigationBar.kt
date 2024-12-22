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

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                content = {
                    NavigationBarItem(
                        selected = false, //choosenItem.value == 0,
                        onClick = { choosenItem.value = 0 },
                        icon = { Image(painter = painterResource(R.drawable.ic_home_menu), contentDescription = "") },
                        label = {
                            Text(
                                fontSize = 10.sp,
                                text = "Ana Sayfa",
                                style = if (choosenItem.value == 0) {
                                    TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
                                } else {
                                    TextStyle(fontWeight = FontWeight.Normal, color = Color.Gray)
                                }
                            )
                        }
                    )
                    NavigationBarItem(
                        selected = false, //choosenItem.value == 1,
                        onClick = { choosenItem.value = 1 },
                        icon = { Image(painter = painterResource(R.drawable.ic_qr_menu), contentDescription = "") },
                        label = {
                            Text(
                                fontSize = 10.sp,
                                text = "Qr İşlemleri",
                                style = if (choosenItem.value == 1) {
                                    TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
                                } else {
                                    TextStyle(fontWeight = FontWeight.Normal, color = Color.Gray)
                                }
                            )
                        }
                    )
                    NavigationBarItem(
                        selected = false, //choosenItem.value == 2,
                        onClick = { choosenItem.value = 2 },
                        icon = { Image(painter = painterResource(R.drawable.ic_money_menu), contentDescription = "") },
                        label = {
                            Text(
                                fontSize = 10.sp,
                                text = "Para Transferi",
                                style = if (choosenItem.value == 2) {
                                    TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
                                } else {
                                    TextStyle(fontWeight = FontWeight.Normal, color = Color.Gray)
                                }
                            )
                        }
                    )
                    NavigationBarItem(
                        selected = false, //choosenItem.value == 3,
                        onClick = { choosenItem.value = 3 },
                        icon = { Image(painter = painterResource(R.drawable.ic_payment_menu), contentDescription = "") },
                        label = {
                            Text(
                                fontSize = 10.sp,
                                text = "Ödemeler",
                                style = if (choosenItem.value == 3) {
                                    TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
                                } else {
                                    TextStyle(fontWeight = FontWeight.Normal, color = Color.Gray)
                                }
                            )
                        }
                    )
                    NavigationBarItem(
                        selected = false, //choosenItem.value == 4,
                        onClick = { choosenItem.value = 4 },
                        icon = { Image(painter = painterResource(R.drawable.ic_card_menu), contentDescription = "") },
                        label = {
                            Text(
                                fontSize = 10.sp,
                                text = "Papara Card",
                                style = if (choosenItem.value == 4) {
                                    TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
                                } else {
                                    TextStyle(fontWeight = FontWeight.Normal, color = Color.Gray)
                                }
                            )
                        }
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(choosenItem.value) {
                0 -> Navigation(chosenScreen = Screens.ScreenHome.route)
                1 -> Navigation(chosenScreen = Screens.ScreenQrTransactions.route)
                2 -> Navigation(chosenScreen = Screens.ScreenMoneyTransfer.route)
                3 -> Navigation(chosenScreen = Screens.ScreenPayments.route)
                4 -> Navigation(chosenScreen = Screens.ScreenPaparaCard.route)
            }
        }
    }
}

