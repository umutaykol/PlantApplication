package com.example.plantapp.feature.home.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.plantapp.util.Roboto
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.asComposeRenderEffect
import com.example.plantapp.model.Question
import com.example.plantapp.ui.common.sampleQuestions


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun PlantQuestionCard(
    question: Question,
    onClick: (Question) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 164.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable() {
                onClick(question)
            }
    ) {
        // Background Image
        AsyncImage(
            model = question.imageUri,
            contentDescription = "Plant Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        // Blurred Layer
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomStart)
                .graphicsLayer {
                    renderEffect = RenderEffect
                        .createBlurEffect(20f, 20f, Shader.TileMode.CLAMP)
                        .asComposeRenderEffect()
                }
                .background(Color.Black.copy(alpha = 0.35f))
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomStart)
                .padding(14.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = question.title ?: "",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Roboto,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview()
@Composable
fun PlantQuestionCardPreview() {
    PlantQuestionCard(
        sampleQuestions.first()
    )
}