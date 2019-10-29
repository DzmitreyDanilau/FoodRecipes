package by.dzmitrey.danilau.foodrecipies.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.util.DATA_BASE_NAME
import io.reactivex.Flowable

@Dao
interface RecipeDao {
    @Query("SELECT * FROM $DATA_BASE_NAME")
    fun getRecipes(): Flowable<List<RecipeLocal>>
    @Insert
    fun saveRecipes(recipes: List<RecipeLocal>)

}