package com.abdulkadirkara.paparauiclonecompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.CustomTopAppBar
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.Story
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.StoryList

@Preview(showSystemUi = true)
@Composable
fun ScreenHome(){

    // ScrollState oluştur
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CustomTopAppBar()
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(scrollState),
        ) {
            val storyList = listOf(
                Story(R.drawable.img_wrap_up_papara_cachback, "Cashback"),
                Story(R.drawable.img, "Duyurular"),
                Story(R.drawable.img_wrap_up_invite_friends, "Davet Et,\nKazan"),
                Story(R.drawable.img_wrap_up_international_transfer, "Yurt Dışı Para\nTransferi"),
                Story(R.drawable.img_wrap_up_papara_chat, "Sohbetler"),
                Story(R.drawable.img_wrap_up_papara_international, "Seyahat\nAyrıcalıkları"),
                Story(R.drawable.img_1, "Kıymetli\nMadenler"),
                Story(R.drawable.img_wrap_up_papara_iban, "Aylık Özet"),
            )

            StoryList(stories = storyList)
        }
    }
}