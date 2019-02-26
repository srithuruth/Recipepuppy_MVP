package com.example.recipepuppy_mvp.ui.di

import com.example.recipepuppy_mvp.network.RecipeService
import com.example.recipepuppy_mvp.ui.HomeContract
import com.example.recipepuppy_mvp.ui.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View){

    @HomeScope
    @Provides
    fun provideHomePresenter(Service: RecipeService): HomeContract.Presenter{
        return HomePresenter(Service, view)
    }
}