package com.example.recipepuppy_mvp.ui

import com.example.recipepuppy_mvp.network.RecipeService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter(
    private val recipeService: RecipeService,
    private val view: HomeContract.View
) : HomeContract.Presenter {

    private val compositeDisposable = CompositeDisposable()




    override fun getRecipe() {
        compositeDisposable.add(recipeService.getRecipeAndIngredients(title = "", ingredients = "")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({view.showRecipe(it)}, { throwable -> view.showError(throwable.message!!) }))

    }
}

