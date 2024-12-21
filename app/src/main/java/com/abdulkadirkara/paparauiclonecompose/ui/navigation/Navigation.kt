package com.abdulkadirkara.paparauiclonecompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdulkadirkara.paparauiclonecompose.ui.screens.ScreenCashbacks
import com.abdulkadirkara.paparauiclonecompose.ui.screens.ScreenHome
import com.abdulkadirkara.paparauiclonecompose.ui.screens.ScreenMoneyTransfer
import com.abdulkadirkara.paparauiclonecompose.ui.screens.ScreenPaparaCard
import com.abdulkadirkara.paparauiclonecompose.ui.screens.ScreenPayments
import com.abdulkadirkara.paparauiclonecompose.ui.screens.ScreenQrTransactions

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ScreenHome.route) {
        composable(route = Screens.ScreenHome.route){
            ScreenHome()
        }
        composable(route = Screens.ScreenCashbacks.route){
            ScreenCashbacks()
        }
        composable(route = Screens.ScreenQrTransactions.route){
            ScreenQrTransactions()
        }
        composable(route = Screens.ScreenMoneyTransfer.route) {
            ScreenMoneyTransfer()
        }
        composable(route = Screens.ScreenPayments.route) {
            ScreenPayments()
        }
        composable(route = Screens.ScreenPaparaCard.route) {
            ScreenPaparaCard()
        }
    }
}