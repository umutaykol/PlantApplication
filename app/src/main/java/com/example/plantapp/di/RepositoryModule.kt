package com.example.plantapp.di

import com.example.plantapp.repository.remote.category.CategoryRepository
import com.example.plantapp.repository.remote.category.CategoryRepositoryImpl
import com.example.plantapp.repository.remote.question.QuestionRepository
import com.example.plantapp.repository.remote.question.QuestionRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindQuestionRepository(
        repository: QuestionRepositoryImpl
    ): QuestionRepository

    @Binds
    fun bindCategoryRepository(
        repository: CategoryRepositoryImpl
    ): CategoryRepository
}