package by.dzmitrey.danilau.foodrecipies.di.modules

import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListInteractorsModule
import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListNetworkModule
import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListRepositoriesModule
import by.dzmitrey.danilau.foodrecipies.ui.activities.LoginActivity
import by.dzmitrey.danilau.foodrecipies.ui.activities.RecipeListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            RecipeViewModelModule::class,
            RecipeListRepositoriesModule::class,
            RecipeListNetworkModule::class,
            RecipeListInteractorsModule::class,
            SharedPreferenceModule::class
        ]
    )
    abstract fun contributeRecipeListActivity(): RecipeListActivity

    @ContributesAndroidInjector
    abstract fun contrebuteLoginActivity(): LoginActivity
}