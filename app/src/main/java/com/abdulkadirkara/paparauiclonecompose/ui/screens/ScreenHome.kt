package com.abdulkadirkara.paparauiclonecompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.CustomTopAppBar
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.Story
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.StoryList
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerFifth
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerFirst
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerFourth
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerLast
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerSecond
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerThird
import com.abdulkadirkara.paparauiclonecompose.ui.theme.papara_black
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Preview(showSystemUi = true)
@Composable
fun ScreenHome() {

    // ScrollState oluştur
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CustomTopAppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(scrollState),
        ) {

            //Hikayeler
            HomeScreenStories()

            //Card ViewPager
            HomeScreenVierPagerCards()
            
        }
    }
}

@Composable
fun HomeScreenStories(){
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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreenVierPagerCards() {
    // Pager state oluştur
    val pagerState = rememberPagerState(pageCount = 6)

    // HorizontalPager yapılandırması
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.86f) // Her elemanın genişliğini azaltarak kenarların görünmesini sağla
            ) {
                when (page) {
                    0 -> CardPagerFirst()
                    1 -> CardPagerSecond()
                    2 -> CardPagerThird()
                    3 -> CardPagerFourth()
                    4 -> CardPagerFifth()
                    5 -> CardPagerLast()
                }
            }
        }
    }

    // Sayfa gösterge noktaları (indicator)
    PageIndicator(
        pageCount = 6,
        currentPage = pagerState.currentPage,
        modifier = Modifier
            .wrapContentWidth()
    )
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage, modifier = modifier)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    Box(
        modifier = modifier
            .padding(2.dp)
            .size(10.dp)
            .clip(CircleShape)
            .background(if (isSelected) papara_black else Color.LightGray)
    )
}
