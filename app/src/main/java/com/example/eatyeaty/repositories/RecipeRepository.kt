package com.example.eatyeaty.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eatyeaty.fixtures.recipe1
import com.example.eatyeaty.fixtures.recipe2

class RecipeRepository {

    private var recipes = MutableLiveData<List<Recipe>>(
        listOf(recipe1, recipe2)
    )

    fun observeAll(): LiveData<List<Recipe>> = recipes

    fun getOne(id: String): Recipe? {
        return recipes.value?.find { it.id == id }
    }

    fun update(recipe: Recipe) {
        recipes.postValue(
            recipes.value?.map {
                if (it.id == recipe.id) recipe else it
            }
        )
    }

    fun create(recipe: Recipe) {
        recipes.postValue((recipes.value ?: listOf()) + recipe)
    }

    companion object {
        private var INSTANCE: RecipeRepository? = null;
        fun getInstance(): RecipeRepository {
            if (INSTANCE != null) {
                return INSTANCE!!
            }
            synchronized(this::class.java) {
                return INSTANCE ?: RecipeRepository().also { INSTANCE = it }
            }
        }
    }
}