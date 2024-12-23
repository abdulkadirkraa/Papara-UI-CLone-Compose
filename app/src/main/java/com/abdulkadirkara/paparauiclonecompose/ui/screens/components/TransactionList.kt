package com.abdulkadirkara.paparauiclonecompose.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.ui.theme.grey
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_bold
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_medium

@Composable
fun TransactionList(transactionModel: TransactionModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp) // Yüksekliği artırarak daha ferah bir görünüm sağlıyoruz.
            .padding(horizontal = 16.dp), // Sağ ve soldan iç boşluk ekliyoruz.
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profil Görseli
        Image(
            painter = painterResource(transactionModel.imgRes),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(45.dp) // Görselin boyutunu belirtiyoruz.
                .clip(CircleShape) // Görseli yuvarlak yapıyoruz.
                .background(grey) // Arka plan gri.
                .padding(2.dp) // Görsel ile dış çerçeve arasında boşluk.
        )

        Spacer(modifier = Modifier.width(12.dp)) // Görsel ile metinler arasında boşluk.

        // Metin Bölgesi
        Column(
            modifier = Modifier.weight(1f), // Metinlerin genişliği, kalan alanı kaplayacak.
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = transactionModel.textTitle,
                fontFamily = investment_bold,
                fontSize = 15.sp,
                color = Color.Black,
                //modifier = Modifier.padding(2.dp),
                lineHeight = 15.sp
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = transactionModel.textDescription,
                fontFamily = investment_medium,
                fontSize = 12.sp, // Daha okunabilir bir font boyutu.
                color = Color.DarkGray,
                lineHeight = 12.sp

            )
        }

        // Sağ Tarafta Para ve Tarih Bilgisi
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = transactionModel.textMoney,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = transactionModel.textMoneyColor,
                //modifier = Modifier.padding(2.dp),
                lineHeight = 16.sp
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = transactionModel.textDate,
                fontFamily = investment_medium,
                color = Color.DarkGray,
                fontSize = 12.sp,
                lineHeight = 12.sp
            )
        }
    }
}

data class TransactionModel(
    val imgRes: Int,
    val textTitle: String,
    val textDescription: String,
    val textMoney: String,
    val textMoneyColor: Color,
    val textDate: String
)