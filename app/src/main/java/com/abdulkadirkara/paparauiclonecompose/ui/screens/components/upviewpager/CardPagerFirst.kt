package com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.abdulkadirkara.paparauiclonecompose.ui.theme.pager_stroke
import com.abdulkadirkara.paparauiclonecompose.ui.theme.very_light_gray

@Preview(showBackground = true)
@Composable
fun CardPagerFirst() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        //elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = very_light_gray)
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
                    .padding(vertical = 12.dp),
                thickness = 1.dp,
                color = pager_stroke
            )

            Text(
                modifier = Modifier.padding(top = 12.dp),
                text = "₺999,92",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = investment_semibold,
                    fontSize = 28.sp
                ),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "IBAN ın:",
                    fontSize = 10.sp,
                    fontFamily = investment_medium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "TR57 0082 9000 0949 1658 5344 20",
                    fontSize = 10.sp,
                    fontFamily = investment_medium,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
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