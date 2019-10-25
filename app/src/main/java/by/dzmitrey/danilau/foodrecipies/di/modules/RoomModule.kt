package by.dzmitrey.danilau.foodrecipies.di.modules

import android.app.Application
import androidx.room.Room
import by.dzmitrey.danilau.foodrecipies.di.scopes.ApplicationScope
import by.dzmitrey.danilau.foodrecipies.sources.local.ILocalStorage
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipeDao
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipesDataBase
import dagger.Module
import dagger.Provides
import timber.log.Timber

@Module
class RoomModule {

    @ApplicationScope
    @Provides
    fun providesDatabaseEntity(application: Application): ILocalStorage {
        val dataBase = Room.databaseBuilder(
            application,
            RecipesDataBase::class.java,
            by.dzmitrey.danilau.foodrecipies.util.DATA_BASE_NAME
        )
            .build()
        Timber.d("DataBase entity: $dataBase")

        return dataBase
    }

    @ApplicationScope
    @Provides
    fun providesProductDao(demoDatabase: ILocalStorage): RecipeDao {
        Timber.d("RecipeDao initialized")
        return demoDatabase.getRecipeDao()
    }


}