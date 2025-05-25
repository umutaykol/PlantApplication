package com.example.plantapp.repository.remote.category

import com.example.plantapp.api.DummyApiDataStore
import com.example.plantapp.model.CategoryResponse
import retrofit2.HttpException
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val apiDataStore: DummyApiDataStore
) : CategoryRepository {

    override suspend fun getCategories(): CategoryResponse {
        val response = apiDataStore.getCategories()
        val body = response.body()
        body.takeIf { response.isSuccessful }?.let {
            return it
        } ?: throw HttpException(response)
    }
}