package com.abdulkadirkara.paparauiclonecompose.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.paparauiclonecompose.ui.theme.pager_stroke
import com.abdulkadirkara.paparauiclonecompose.ui.theme.papara_regular

@Composable
fun StoryList(stories: List<Story>) {
    // Her hikayenin tıklama durumunu takip eden liste
    val selectedStoryStates =
        remember { mutableStateListOf<Boolean>().apply { repeat(stories.size) { add(false) } } }
    val sortedStories = remember { stories.toMutableList() } // Hikayeleri sıralı tut

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        itemsIndexed(sortedStories) { index, story ->
            val isSelected = selectedStoryStates[index]
            val interactionSource = remember { MutableInteractionSource() }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        // Tıklanan hikayenin durumunu değiştir
                        selectedStoryStates[index] = !isSelected

                        // Eğer hikaye seçildiyse, onu listenin sonuna taşıyoruz
                        if (!isSelected) {
                            sortedStories
                                .removeAt(index)
                                .also { storyToMove ->
                                    sortedStories.add(storyToMove)
                                    selectedStoryStates.removeAt(index)
                                    selectedStoryStates.add(true)
                                }
                        }
                    }
            ) {
                StoryImage(story.imageRes, isSelected)
                Spacer(modifier = Modifier.height(8.dp))
                StoryTitle(story.title)
            }
        }
    }
}

@Composable
fun StoryImage(imageRes: Int, isSelected: Boolean) {
    // Resmi eklerken, seçili olup olmadığını kontrol ederek kenarlık rengini ayarlıyoruz
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .border(
                2.dp,
                color = if (isSelected) pager_stroke else Color.Black,
                CircleShape
            )
    )
}

@Composable
fun StoryTitle(title: String) {
    Text(
        text = title,
        textAlign = TextAlign.Center,
        fontFamily = papara_regular,
        fontSize = 9.sp,
        lineHeight = 12.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    )
}

data class Story(
    val imageRes: Int,
    val title: String
)