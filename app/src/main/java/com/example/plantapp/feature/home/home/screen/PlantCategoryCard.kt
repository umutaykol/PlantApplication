package com.example.plantapp.feature.home.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.plantapp.model.CategoryData
import com.example.plantapp.ui.common.sampleCategories
import com.example.plantapp.util.Roboto

@Composable
fun PlantCategoryCard(
    category: CategoryData,
    onClick: (CategoryData) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .size(152.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color(0xFFF4F6F6))
            .border(
                width = 0.5.dp,
                color = Color(0xFFBDBDBD),
                shape = RoundedCornerShape(12.dp)
            ).clickable {
                onClick(category)
            }
    ) {
        AsyncImage(
            model = category.image?.url,
            contentDescription = "${category.title} Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 40.dp, top = 16.dp)
                .align(Alignment.BottomEnd)
        )
        Text(
            text = category.title ?: "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 12.dp, top = 12.dp, end = 60.dp),
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 21.sp,
            letterSpacing = 0.sp,
            fontFamily = Roboto
        )
    }
}

@Preview
@Composable
fun PlantCategoryCardPreview() {
    PlantCategoryCard(
        sampleCategories.first()
    )
}