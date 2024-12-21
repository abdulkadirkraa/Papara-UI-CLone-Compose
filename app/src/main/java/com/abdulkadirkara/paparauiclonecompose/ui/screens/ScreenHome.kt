package com.abdulkadirkara.paparauiclonecompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.CustomTopAppBar
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.Story
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.StoryList
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerCommon
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerFirst
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerLast
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
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

            //Hikayeler
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

            //Card ViewPager
            val pages = listOf(
                CardPagerFirst(),
                CardPagerCommon(
                    drawableIcon = R.drawable.img_precious_metal_header,
                    titleText = "Kıymetli\nMadenler",
                    descText = "(Altın, Gümüş, Platin)",
                    drawableImg = R.drawable.img_no_precious_metal,
                    btnText = "Kıymetli Madenler Hesabı Aç",
                ),
                CardPagerCommon(
                    drawableIcon = R.drawable.ic_no_saving_header,
                    titleText = "Birikim Hesabı",
                    descText = "Hedef belirle, birikim yap.",
                    drawableImg = R.drawable.img_no_saving,
                    btnText = "Birikim Hesabı Aç"
                ),
                CardPagerCommon(
                    drawableIcon = R.drawable.img_3,
                    titleText = "Yatırım Hesabı",
                    descText = "Hisse senedi al/ sat",
                    drawableImg = R.drawable.img_no_investment,
                    btnText = "Gelince Haber Ver"
                ),
                CardPagerCommon(
                    drawableIcon = R.drawable.ic_no_foreign_header,
                    titleText = "Döviz Hesapları",
                    descText = "(Dolar, Euro)",
                    drawableImg = R.drawable.img_no_foreign_currency,
                    btnText = "Gelince Haber Ver"
                ),
                CardPagerLast()
            )

            // HorizontalPager ile sayfaları görüntüle
            val pagerState = rememberPagerState(pageCount = pages.size)
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.wrapContentSize()
                    .padding(12.dp)
            ) { page ->
                pages[page]
            }

        }
    }
}
