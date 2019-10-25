package by.dzmitrey.danilau.foodrecipies.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal

const val DATA_BASE_VERSION = 1

@Database(entities = [RecipeLocal::class], version = DATA_BASE_VERSION, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RecipesDataBase : RoomDatabase(), ILocalStorage {
    override fun getRecipeDao(): RecipeDao {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}