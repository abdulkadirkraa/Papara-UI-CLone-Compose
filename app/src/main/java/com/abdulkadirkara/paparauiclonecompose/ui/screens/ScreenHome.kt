package com.abdulkadirkara.paparauiclonecompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.CustomTopAppBar
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.Story
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.StoryList
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.TransactionList
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.TransactionModel
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerCommon
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerFirst
import com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager.CardPagerLast
import com.abdulkadirkara.paparauiclonecompose.ui.theme.dots_fray_color
import com.abdulkadirkara.paparauiclonecompose.ui.theme.money_green
import com.abdulkadirkara.paparauiclonecompose.ui.theme.money_red
import com.abdulkadirkara.paparauiclonecompose.ui.theme.pades_illustration_pink
import com.abdulkadirkara.paparauiclonecompose.ui.theme.pager_stroke
import com.abdulkadirkara.paparauiclonecompose.ui.theme.papara_bold
import com.abdulkadirkara.paparauiclonecompose.ui.theme.papara_regular
import com.abdulkadirkara.paparauiclonecompose.ui.theme.very_light_gray
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
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(scrollState),
        ) {

            //Hikayeler
            HomeScreenStories()

            //Card ViewPager
            HomeScreenViewPagerCards()

            //Hesap Hareketleri Text ve Transaction'lar
            HomeScreenTransaction()

            //Cashback text ve card'ı
            HomeScreenCashback()

            //Arkadaşlarını davet et card'ı
            HomeScreenInviteFriendsCard()

        }
    }
}

@Composable
fun HomeScreenInviteFriendsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = pades_illustration_pink)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min) // Row'un yüksekliğini içeriğe göre ayarlıyoruz
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight() // Tüm dikey alanı doldur
                    .padding(start = 12.dp, top = 12.dp, bottom = 12.dp),
                verticalArrangement = Arrangement.SpaceBetween, // Textler biri üstte, biri altta olacak
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Arkadaşını Davet Et,\nBirlikte Kazan",
                    fontFamily = papara_bold,
                    color = Color.Black,
                    fontSize = 15.sp
                )
                Text(
                    text = "Detaylı Bilgi",
                    fontFamily = papara_regular,
                    color = Color.Black,
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            Image(
                painter = painterResource(R.drawable.img_wrap_up_gift),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .padding(end = 12.dp) // Görsel için boşluk
            )
        }
    }
}

@Composable
fun HomeScreenCashback() {
    val totalAmount = 2225f // Divider'ın toplam değeri
    val currentAmount = 535f // Resmin hizalanacağı değer
    val positionFraction = currentAmount / totalAmount // Oran

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp)
        ) {
            CustomTransactionAndCashbackHeader("CASHBACK")
            Spacer(Modifier.height(8.dp))
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = very_light_gray)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Bu ay kazandığın",
                        color = Color.DarkGray
                    )
                    Text(
                        text = "Bu ay kazanabileceğin",
                        color = Color.DarkGray
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "₺535,00",
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontFamily = papara_bold
                    )
                    Text(
                        text = "₺2225,00",
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontFamily = papara_bold
                    )
                }

                // Divider ve İkon
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    // Divider
                    HorizontalDivider(
                        modifier = Modifier
                            .height(3.dp)
                            .fillMaxWidth()
                            .background(pager_stroke)
                    )

                    // Resim (Dinamik Konum)
                    BoxWithConstraints {
                        val boxWidth = maxWidth
                        Image(
                            painter = painterResource(id = R.drawable.ic_info_cashback),
                            contentDescription = "Cashback Icon",
                            modifier = Modifier
                                .size(40.dp)
                                .offset(
                                    x = (boxWidth * positionFraction) - 20.dp // Ortalamak için yarıçap çıkarılır
                                )
                                .background(color = very_light_gray, shape = CircleShape)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreenTransaction() {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp)
        ) {
            CustomTransactionAndCashbackHeader("HESAP HAREKETLERİ")
        }

        val transactions = listOf(
            TransactionModel(
                imgRes = R.drawable.ic_papara_cashback,
                textTitle = "Spotify",
                textDescription = "Papara Cashback",
                textMoney = "₺20,00",
                textMoneyColor = money_green,
                textDate = "22 Aralık 2024 17:50"
            ),
            TransactionModel(
                imgRes = R.drawable.ic_spotify,
                textTitle = "Spotify",
                textDescription = "Papara Card",
                textMoney = "₺59,99",
                textMoneyColor = money_red,
                textDate = "22 Aralık 2024 17:50"
            )
        )

        for (i in transactions.indices){
            TransactionList(transactions[i])
        }
    }
}

@Composable
fun CustomTransactionAndCashbackHeader(title: String) {
    // Text with drawable at the end
    Text(
        text = title,
        fontFamily = papara_regular,
        color = Color.DarkGray,
        fontSize = 11.sp,
        modifier = Modifier.padding(end = 4.dp),
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Ellipsis
    )
    Spacer(Modifier.width(4.dp))
    // Drawable (icon) at the end
    Image(
        painter = painterResource(id = R.drawable.arrow_right_drawable),
        contentDescription = "Arrow Icon"
    )
}

@Composable
fun HomeScreenStories() {
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
fun HomeScreenViewPagerCards() {
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
                    1 -> {
                        CardPagerCommon(
                            iconImg = R.drawable.img_precious_metal_header,
                            titleText = "Kıymetli Madenler",
                            descText = "(Altın, Gümüş, Platin)",
                            imgRes = R.drawable.img_no_precious_metal,
                            btnText = "Kıymetli Madenler Hesabı Aç",
                            btnIcon = R.drawable.abc_ic_go_search_api_material
                        )
                    }
                    2 -> {
                        CardPagerCommon(
                            iconImg = R.drawable.ic_no_saving_header,
                            titleText = "Birikim Hesabı",
                            descText = "Hedef belirle, birikim yap",
                            imgRes = R.drawable.img_no_saving,
                            btnText = "Birikim Hesabı Aç",
                            btnIcon = R.drawable.abc_ic_go_search_api_material
                        )
                    }
                    3 -> {
                        CardPagerCommon(
                            iconImg = R.drawable.img_3,
                            titleText = "Yatırım Hesabı",
                            descText = "Hisse senedi al/ sat",
                            imgRes = R.drawable.img_no_investment,
                            btnText = "Gelince Haber Ver",
                            btnIcon = R.drawable.ic_investment_notification_black
                        )
                    }
                    4 -> {
                        CardPagerCommon(
                            iconImg = R.drawable.ic_no_foreign_header,
                            titleText = "Döviz Hesapları",
                            descText = "(Dolar, Euro)",
                            imgRes = R.drawable.img_no_foreign_currency,
                            btnText = "Gelince Haber Ver",
                            btnIcon = R.drawable.ic_investment_notification_black
                        )
                    }
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
            Spacer(Modifier.width(4.dp))
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    Box(
        modifier = modifier
            .padding(2.dp)
            .size(6.dp)
            .clip(CircleShape)
            .background(if (isSelected) Color.Black else dots_fray_color)
    )
}
