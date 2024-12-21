package com.abdulkadirkara.paparauiclonecompose.ui.screens.components.upviewpager

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.R
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_medium
import com.abdulkadirkara.paparauiclonecompose.ui.theme.investment_semibold

@Composable
fun CardPagerCommon(
    drawableIcon: Int,
    titleText: String,
    descText: String,
    drawableImg: Int,
    btnText: String,
    btnImg: Int = R.drawable.abc_ic_go_search_api_material
){
    Card(
        modifier = Modifier.fillMaxWidth()
            .height(265.dp),
    ){
        Image(
            painter = painterResource(R.drawable.drawable_lighter_grey_bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(drawableIcon),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        2.dp,
                        color = Color.White,
                        CircleShape
                    )
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 14.dp)
            ){
                Column {
                    Text(
                        text = titleText,
                        fontFamily = investment_semibold,
                        color = Color.Black,
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = descText,
                        fontFamily = investment_medium,
                        fontSize = 11.sp
                    )
                }

                Image(
                    painter = painterResource(drawableImg),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(140.dp)
                        .padding(top = 12.dp, end = 28.dp)
                )
            }

            CustomButton(
                text = btnText,
                iconRes = btnImg,
                onClick = { /* Buton tıklama işlemi */ }
            )

        }
    }
}

@Composable
fun CustomButton(
    text: String,
    iconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.White
    ),
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
) {
    Button(
        onClick = onClick,
        colors = buttonColors,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        contentPadding = contentPadding,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                style = textStyle,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.Black // İkon rengi
            )
        }
    }
}