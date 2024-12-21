package com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun CardPagerLast(){
    Card (modifier = Modifier.fillMaxWidth()
        .height(265.dp),) {

        Image(
            painter = painterResource(id = R.drawable.drawable_lighter_grey_bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.LightGray)
        ) {
            // Header Text (Tüm Varlıklarım)
            Text(
                text = "Tüm Varlıklarım",
                fontFamily = FontFamily(Font(R.font.papara_regular)),
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp)
                    .background(Color.White, shape = RoundedCornerShape(20.dp))
                    .border(2.dp, Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(start = 8.dp, end = 8.dp)
            )

            // Precious Amount Text (₺999,92)
            Text(
                text = "₺999,92",
                fontFamily = FontFamily(Font(R.font.investment_semi_bold)),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

            // Türk Lirası Hesabı
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .wrapContentHeight()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.turkish_flag_16px),
                    contentDescription = "Türk Lirası Hesabı",
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Türk Lirası Hesabı",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
                Text(text = "₺999,92", style = MaterialTheme.typography.bodySmall)
            }

            // Kıymetli Madenler
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_wrap_up_gold_18dp),
                    contentDescription = "Kıymetli Madenler",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Kıymetli Madenler",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
                Text(text = "__", style = MaterialTheme.typography.bodySmall)
            }

            // Yatırım Hesabı
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_investment_18dp),
                    contentDescription = "Yatırım Hesabı",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Yatırım Hesabı",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
                Text(text = "__", style = MaterialTheme.typography.bodySmall)
            }

            // Birikim Hesabı
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_no_saving_header_18dp),
                    contentDescription = "Birikim Hesabı",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Birikim Hesabı",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
                Text(text = "__", style = MaterialTheme.typography.bodySmall)
            }

            // Info Icon (Bilgi ikonu sağda)
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_info_request_money),
                    contentDescription = "Info Icon",
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                )
            }
        }
    }
}