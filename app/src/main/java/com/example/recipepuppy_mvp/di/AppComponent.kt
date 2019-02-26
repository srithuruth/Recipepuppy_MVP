package com.example.recipepuppy_mvp.di

import com.example.recipepuppy_mvp.network.RecipeService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton

interface AppComponent{
    fun RecipeService(): RecipeService
}