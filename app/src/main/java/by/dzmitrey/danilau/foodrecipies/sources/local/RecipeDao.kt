package by.dzmitrey.danilau.foodrecipies.sources.local

import androidx.room.*
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.util.DATA_BASE_NAME
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface RecipeDao {

    @Query("SELECT * FROM $DATA_BASE_NAME WHERE title LIKE '%' || :query || '%' ")
    fun getRecipes(query: String): Flowable<List<RecipeLocal>>

    @Insert
    fun save(item: RecipeLocal)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(itemsList: List<RecipeLocal>)

    @Delete
    fun delete(item: RecipeLocal)

    @Update
    fun update(item: RecipeLocal)
}