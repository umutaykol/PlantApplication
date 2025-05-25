package com.example.plantapp.feature.home.home.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import com.example.plantapp.model.CategoryData
import com.example.plantapp.model.Question
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantapp.ui.common.sampleCategories
import com.example.plantapp.ui.common.sampleQuestions
import com.example.plantapp.R

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HomePageScreen(
    questions: List<Question>,
    categories: List<CategoryData>,
    modifier: Modifier = Modifier,
    isQuestionsLoading: Boolean = false,
    questionsError: String? = null,
    isCategoriesLoading: Boolean = false,
    isCategoriesErrorAvailable: Boolean = false,
    onQuestionClicked: (Question) -> Unit = {},
    onCategoryClicked: (CategoryData) -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF6F6F6))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 46.dp)
                ) {
                    Text(
                        text = "Hi, plant lover!",
                        fontSize = 16.sp,
                        color = Color(0xFF13231B),
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Good Afternoon! ⛅",
                        fontSize = 24.sp,
                        color = Color(0xFF13231B),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image_homepage_background),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .offset(y = (-16).dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.image_search_bar),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .align(Alignment.TopCenter)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.image_free_premium_available),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp)
                    )
                }
            }
            item {
                if (isQuestionsLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else if (questionsError != null) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = questionsError,
                            color = Color.Red,
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else {
                    LazyRow(
                        contentPadding = PaddingValues(top = 24.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(questions) { question ->
                            PlantQuestionCard(
                                question = question,
                                onClick = onQuestionClicked
                            )
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                if (isCategoriesLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else if (isCategoriesErrorAvailable) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Failed to load categories",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 1000.dp)
                    ) {
                        items(categories) { category ->
                            PlantCategoryCard(
                                category = category,
                                onClick = onCategoryClicked
                            )
                        }
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun HomePageScreenPreview() {
    HomePageScreen(
        sampleQuestions,
        sampleCategories
    )
}