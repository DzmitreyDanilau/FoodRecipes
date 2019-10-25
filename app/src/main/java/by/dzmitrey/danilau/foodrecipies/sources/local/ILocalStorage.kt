package by.dzmitrey.danilau.foodrecipies.sources.local

import io.reactivex.Observable

interface ILocalStorage {
    fun getRecipeDao(): RecipeDao
    interface SharedPreferencesStorage {
        fun readData(): Observable<String>
        fun writeData(data: String)
    }
}