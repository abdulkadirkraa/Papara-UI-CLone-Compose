package com.abdulkadirkara.paparauiclonecompose.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.theme.dark_gray
import com.abdulkadirkara.paparauiclonecompose.ui.theme.very_light_gray

//Her bir ikon kartını özelleştirmek için
@Composable
fun CustomTopAppBarOutlinedCard(containerColor: Color, icon: Int, padding: Int = 0) {
    OutlinedCard(
        modifier = Modifier
            .size(40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(icon), contentDescription = "",
                modifier = Modifier
                    .padding(padding.dp)
                    .size(40.dp)
            )
        }
    }
}

//topbar'daki text'ler özelleştirmek için
@Composable
fun CustomTopAppBarText(
    text: String,
    color: Color,
    size: Int,
    textDecoration: TextDecoration = TextDecoration.None
) {
    Text(
        text = text,
        color = color,
        fontSize = size.sp,
        textDecoration = textDecoration,
        lineHeight = size.sp
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTopAppBar() {
    //Tüm yapı yan yana olacak
    //soldaki menu ve chat ikon bir row'da sağdaki yapılar bir row'da bu sayede ekranın iki köşesine atabilirim
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            //bottom padding vermedim çünkü hikayelerde ayarlamak için
            .padding(start = 12.dp, end = 12.dp, top = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // sol taraftaki menu ve chat iconu
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CustomTopAppBarOutlinedCard(
                containerColor = very_light_gray,
                R.drawable.ic_drawer_menu,
                padding = 12
            )

            Spacer(modifier = Modifier.padding(2.dp))

            CustomTopAppBarOutlinedCard(containerColor = Color.White, R.drawable.ic_chat)
        }

        // Sağdaki text ve kişi icon kısmı
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            // Alt alta olan text'ler için
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                CustomTopAppBarText(
                    text = "Abdulkadir Kara",
                    color = dark_gray,
                    size = 10
                )
                Row {
                    CustomTopAppBarText(
                        text = "Papara No:",
                        color = dark_gray,
                        size = 10
                    )
                    CustomTopAppBarText(
                        text = "1111111111",
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline,
                        size = 10
                    )
                }
            }

            Spacer(modifier = Modifier.padding(4.dp))

            CustomTopAppBarOutlinedCard(
                containerColor = Color.White,
                icon = R.drawable.ic_add_profile_photo
            )

        }
    }
}