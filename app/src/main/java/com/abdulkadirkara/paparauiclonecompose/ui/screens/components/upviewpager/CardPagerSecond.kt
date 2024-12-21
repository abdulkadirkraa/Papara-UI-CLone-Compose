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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_medium
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_semibold
import com.abdulkadirkara.paparauiclonecompose.ui.theme.lightGrayDrawableMenu

@Preview(showBackground = true)
@Composable
fun CardPagerSecond() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        //elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = lightGrayDrawableMenu)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            // Row containing left side column and right side image
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                // Left side Column: Icon, Title, Description
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    // Icon
                    Image(
                        painter = painterResource(id = R.drawable.img_precious_metal_header),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .height(24.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Title
                    Text(
                        text = "Kıymetli\nMadenler",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontFamily = investment_semibold,
                            fontSize = 16.sp
                        ),
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Description
                    Text(
                        text = "(Altın, Gümüş, Platin)",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontFamily = investment_medium,
                            fontSize = 12.sp
                        ),
                    )
                }

                // Right side Image
                Image(
                    painter = painterResource(id = R.drawable.img_no_precious_metal),
                    contentDescription = "Image",
                    modifier = Modifier
                        .padding(start = 12.dp)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            CustomButtonCardSecond(
                onClick = { /* İşlem */ },
                buttonText = "Kıymetli Madenler Hesabı Aç",
                drawableEnd = R.drawable.abc_ic_go_search_api_material,
            )
        }
    }
}

@Composable
fun CustomButtonCardSecond(
    onClick: () -> Unit,
    buttonText: String,
    @DrawableRes drawableEnd: Int,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp)) // Yuvarlak köşeleri uygula
            .background(Color(0xa8fefefe)) // Beyaz arka plan
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