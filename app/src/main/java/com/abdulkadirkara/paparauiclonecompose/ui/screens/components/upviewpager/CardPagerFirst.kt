package com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_medium
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_semibold
import com.abdulkadirkara.paparauiclonecompose.ui.theme.lightGrayDrawableMenu

@Preview(showBackground = true)
@Composable
fun CardPagerFirst() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = lightGrayDrawableMenu)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_flag_tl),
                    contentDescription = "Türk Lirası Bayrağı",
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .border(2.dp, color = Color.White, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Türk Lirası Hesabı",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = investment_medium,
                        fontSize = 12.sp
                    ),
                    color = Color.Black
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            Text(
                text = "₺999,92",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = investment_semibold,
                    fontSize = 28.sp
                ),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "IBAN ın:",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 10.sp,
                    fontFamily = investment_medium
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "TR11 3452 6785 7896 9029 4680 11",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 10.sp,
                        fontFamily = investment_medium
                    ),
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomButton(
                    onClick = { /* İşlem */ },
                    buttonText = "Yatır / Çek",
                    drawableEnd = R.drawable.ic_dashboard_wallet,
                    modifier = Modifier.weight(1f)
                )
                CustomButton(
                    onClick = { /* İşlem */ },
                    buttonText = "Gönder",
                    drawableEnd = R.drawable.ic_dashboard_send,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    buttonText: String,
    @DrawableRes drawableEnd: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp)) // Yuvarlak köşeleri uygula
            .background(Color.White) // Beyaz arka plan
            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)) // Hafif gri kenarlık
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(12.dp),
            shape = RoundedCornerShape(8.dp) // Yuvarlak köşe için aynı şekil
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
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = drawableEnd),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}