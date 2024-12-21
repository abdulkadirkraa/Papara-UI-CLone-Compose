package com.abdulkadirkara.paparauiclonecompose.ui.navigation

sealed class Screens(val route: String) {
    object ScreenHome : Screens("home_screen")
    object ScreenCashbacks : Screens("cashbacks_screen")
    object ScreenQrTransactions : Screens("qr_transactions_screen")
    object ScreenMoneyTransfer : Screens("money_transfer_screen")
    object ScreenPayments : Screens("payments_screen")
    object ScreenPaparaCard : Screens("paparacard_screen")
}