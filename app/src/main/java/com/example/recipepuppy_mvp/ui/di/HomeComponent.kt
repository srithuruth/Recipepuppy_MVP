package com.example.recipepuppy_mvp.ui.di

import com.example.recipepuppy_mvp.di.AppComponent
import com.example.recipepuppy_mvp.ui.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun inject (mainActivity: MainActivity)
}