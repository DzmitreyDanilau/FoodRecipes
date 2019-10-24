package by.dzmitrey.danilau.foodrecipies.di.modules

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListLocalDataSource
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipeDao
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipesDataBase
import by.dzmitrey.danilau.foodrecipies.util.DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun providesDatabaseEntity(application: Application): RecipesDataBase? {
        return Room.databaseBuilder(
            application,
            RecipesDataBase::class.java,
            DATA_BASE_NAME
        )
            .build()
    }

    @Singleton
    @Provides
    fun providesProductDao(demoDatabase: RecipesDataBase): RecipeDao? {
        return demoDatabase.getRecipeDao()
    }

    @Singleton
    @Provides
    fun productRepository(productDao: RecipeDao?): RecipeListLocalDataSource? {
        return RecipeListLocalDataSource(productDao!!)
    }
}