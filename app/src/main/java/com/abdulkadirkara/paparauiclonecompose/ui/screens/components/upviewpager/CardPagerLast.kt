package com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.R

@Preview(showBackground = true)
@Composable
fun CardPagerLastUpdated() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Sol taraf (Logo, Tüm Varlıklarım yazısı ve Balance)
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 4.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_papara_rounded_gray),
                                contentDescription = "Logo",
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Tüm Varlıklarım",
                                fontFamily = FontFamily(Font(R.font.papara_regular)),
                                fontSize = 14.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Text(
                            text = "₺999,92",
                            fontFamily = FontFamily(Font(R.font.investment_semi_bold)),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    // Sağ taraf (Icon)
                    Image(
                        painter = painterResource(id = R.drawable.ic_info_request_money),
                        contentDescription = "Info Icon",
                        modifier = Modifier.size(32.dp),
                    )
                }

                // Alt kısımdaki hesap bilgileri
                AccountRow(
                    iconRes = R.drawable.turkish_flag_16px,
                    accountName = "Türk Lirası Hesabı",
                    value = "₺999,92",
                    accountFontFamily = FontFamily(Font(R.font.investment_medium)),
                    valueFontFamily = FontFamily(Font(R.font.investment_semi_bold))
                )
                AccountRow(
                    iconRes = R.drawable.ic_wrap_up_gold_18dp,
                    accountName = "Kıymetli Madenler",
                    value = "__",
                    accountFontFamily = FontFamily(Font(R.font.investment_medium)),
                    valueFontFamily = FontFamily(Font(R.font.investment_semi_bold))
                )
                AccountRow(
                    iconRes = R.drawable.ic_investment_18dp,
                    accountName = "Yatırım Hesabı",
                    value = "__",
                    accountFontFamily = FontFamily(Font(R.font.investment_medium)),
                    valueFontFamily = FontFamily(Font(R.font.investment_semi_bold))
                )
                AccountRow(
                    iconRes = R.drawable.ic_no_saving_header_18dp,
                    accountName = "Birikim Hesabı",
                    value = "__",
                    accountFontFamily = FontFamily(Font(R.font.investment_medium)),
                    valueFontFamily = FontFamily(Font(R.font.investment_semi_bold))
                )
            }
        }
    }
}

@Composable
fun AccountRow(
    iconRes: Int,
    accountName: String,
    value: String,
    accountFontFamily: FontFamily,
    valueFontFamily: FontFamily
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = accountName,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = accountName,
            fontFamily = accountFontFamily,
            fontSize = 13.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            fontFamily = valueFontFamily,
            fontSize = 13.sp,
            color = Color.Black
        )
    }
}
