package com.example.plantapp.ui.common

import com.example.plantapp.model.CategoryData
import com.example.plantapp.model.CategoryImage
import com.example.plantapp.model.Question

val sampleQuestions = listOf(
    Question(
        id = 1,
        title = "What is the best way to care for succulents?",
        subtitle = "Tips and tricks for succulent care",
        imageUri = "https://example.com/succulent.jpg",
        uri = "https://example.com/succulent-care",
        order = 1
    ),
    Question(
        id = 2,
        title = "How to propagate houseplants?",
        subtitle = "A guide to plant propagation",
        imageUri = "https://example.com/propagation.jpg",
        uri = "https://example.com/plant-propagation",
        order = 2
    )
)

val sampleCategories = listOf(
    CategoryData(
        title = "Edible Plants",
        image = CategoryImage(
            url = "https://example.com/edible.jpg"
        )
    ),
    CategoryData(
        title = "Ornamental Plants",
        image = CategoryImage(
            url = "https://example.com/ornamental.jpg"
        )
    ),
    CategoryData(
        title = "Medicinal Plants",
        image = CategoryImage(
            url = "https://example.com/medicinal.jpg"
        )
    ),
    CategoryData(
        title = "Succulents",
        image = CategoryImage(
            url = "https://example.com/succulents.jpg"
        )
    ),
    CategoryData(
        title = "Ferns",
        image = CategoryImage(
            url = "https://example.com/ferns.jpg"
        )
    ),
    CategoryData(
        title = "Cacti",
        image = CategoryImage(
            url = "https://example.com/cacti.jpg"
        )
    )
)