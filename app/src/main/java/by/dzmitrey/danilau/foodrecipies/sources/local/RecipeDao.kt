package by.dzmitrey.danilau.foodrecipies.sources.local

import androidx.room.Dao
import androidx.room.Query
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal

@Dao
interface RecipeDao {
    @Query("SELECT * FROM ")
    fun getRecepies(): List<RecipeLocal>


    
}