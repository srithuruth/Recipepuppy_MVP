package com.example.recipepuppy_mvp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.recipepuppy_mvp.App
import com.example.recipepuppy_mvp.R
import com.example.recipepuppy_mvp.model.Data
import com.example.recipepuppy_mvp.ui.di.HomeModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View{

private val APIAdapter = APIAdapter()

    @Inject
    lateinit var homePresenter: HomePresenter.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        rvIngredients.layoutManager = LinearLayoutManager(this)
        rvIngredients.adapter = APIAdapter


        btnDisplay.setOnClickListener {
            homePresenter.getStockDetails()
        }


    }

    override fun showRecipe(results: List<Data>) {
        APIAdapter.setData(results)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
