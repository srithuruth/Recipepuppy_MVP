package com.example.recipepuppy_mvp.ui

import com.example.recipepuppy_mvp.model.Data

interface HomeContract{
    interface View{
        fun showRecipe(results: List<Data>)
        fun showError(message: String)
    }

    interface Presenter{
       fun getReceipe()
    }
}