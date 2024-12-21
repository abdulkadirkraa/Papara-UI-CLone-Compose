package com.abdulkadirkara.paparauiclonecompose.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.abdulkadirkara.paparauiclonecompose.ui.theme.lightGrayDrawableMenu

@Preview(showBackground = true)
@Composable
fun CustomTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 12.dp, end = 12.dp, top = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // 2 icon button row'u
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedCard(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(40.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = lightGrayDrawableMenu
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight() // Tam alanı kaplar
                ) {
                    Icon(painter = painterResource(R.drawable.ic_drawer_menu), contentDescription = "",
                        modifier = Modifier.padding(12.dp).size(40.dp))
                }
            }

            Spacer(modifier = Modifier.padding(2.dp))

            OutlinedCard(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(40.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight() // Tam alanı kaplar
                ) {
                    Icon(painter = painterResource(R.drawable.ic_chat), contentDescription = "",
                        modifier = Modifier.size(40.dp))
                }
            }
        }

        // Sağdaki text ve kişi icon kısmı
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            // Alt alta olan text'ler için
            Column(horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Abdulkadir Kara",
                    color = Color.LightGray,
                    fontSize = 10.sp
                )
                Row {
                    Text(
                        text = "Papara No:",
                        color = Color.LightGray,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "1111111111",
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 10.sp
                    )
                }
            }

            Spacer(modifier = Modifier.padding(4.dp))

            OutlinedCard(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(40.dp), // Kartın boyutu
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight() // Tam alanı kaplar
                ) {
                    Icon(painter = painterResource(R.drawable.ic_add_profile_photo), contentDescription = "",
                        Modifier.size(40.dp))
                }
            }
        }
    }
}