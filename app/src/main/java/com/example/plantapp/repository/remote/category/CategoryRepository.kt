package com.example.plantapp.repository.remote.category

import com.example.plantapp.model.CategoryResponse


interface CategoryRepository {

    suspend fun getCategories(): CategoryResponse
}