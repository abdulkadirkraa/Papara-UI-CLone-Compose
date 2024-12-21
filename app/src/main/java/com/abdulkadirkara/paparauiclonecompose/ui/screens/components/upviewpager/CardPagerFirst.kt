package com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_medium
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_semibold
import com.abdulkadirkara.paparauiclonecompose.ui.theme.pager_stroke
import com.abdulkadirkara.paparauiclonecompose.ui.theme.papara_black


@Preview(showBackground = true)
@Composable
fun CardPagerFirst(){
    Card(
        modifier = Modifier.fillMaxWidth()
            .height(265.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.drawable_lighter_grey_bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center) {
            // Tr bayrak ikon ve text
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_flag_tl),
                    contentDescription = "",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .border(
                            2.dp,
                            color = Color.White,
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Türk Lirası Hesabı",
                    fontFamily = investment_medium,
                    color = papara_black,
                    fontSize = 12.sp
                )

            }

            //Divider
            HorizontalDivider(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                thickness = 1.dp,
                color = pager_stroke
            )

            Spacer(modifier = Modifier.height(32.dp))

            //hesap
            Text(
                text = "₺999,92",
                fontFamily = investment_semibold,
                color = papara_black,
                fontSize = 28.sp
            )

            //Iban kısmı
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 4.dp)
            ) {
                Text(
                    text = "IBAN ın:",
                    fontSize = 10.sp,
                    fontFamily = investment_medium
                )

                Text(
                    text = "TR11 3452 6785 7896 9029 4680 11",
                    fontSize = 10.sp,
                    fontFamily = investment_medium,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(start = 4.dp),
                    color = Color.Black
                )
            }

            //İKi icon button
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomButton(
                    onClick = { /* İşlem */ },
                    buttonText = "Yatır / Çek",
                    drawableEnd = R.drawable.ic_dashboard_wallet
                )
                CustomButton(
                    onClick = {},
                    buttonText = "Gönder",
                    drawableEnd = R.drawable.ic_dashboard_send
                )
            }

        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    buttonText: String,
    @DrawableRes drawableEnd: Int
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min) // `wrap_content`'e benzer
            .padding(end = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent // Drawable arka plan kullanacağız
        ),
        shape = RoundedCornerShape(8.dp), // Drawable'daki köşe yuvarlama ile uyumlu yap
        contentPadding = PaddingValues(12.dp) // İçerik için padding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp)) // Metin ve simge arasında boşluk
            Image(
                painter = painterResource(id = drawableEnd),
                contentDescription = null,
                modifier = Modifier.size(24.dp) // Simge boyutunu ayarla
            )
        }
    }
}