package com.example.recipepuppy_mvp.network

import com.example.recipepuppy_mvp.model.Data
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface RecipeService{

    @GET(END_POINT)

    fun getRecipeAndIngredients(@Query("title") title: String,
                                @Query("ingredients") ingredients: String) : Observable<List<Data>>



    /*
        @GET(END_POINT)
    fun getRecipe(): Observable<Response>

    @GET(END_POINT)
    fun getIngredients(): Observable<List<Respose>>
     */
}



//http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet&p=3