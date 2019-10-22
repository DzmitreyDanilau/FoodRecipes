package by.dzmitrey.danilau.foodrecipies.di.modules

import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListNetworkModule
import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListRepositoryModule
import by.dzmitrey.danilau.foodrecipies.di.scopes.RecipeListScope
import by.dzmitrey.danilau.foodrecipies.ui.activities.RecipeListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @RecipeListScope
    @ContributesAndroidInjector(
        modules = [
            RecipeViewModelModule::class,
            RecipeListRepositoryModule::class,
            RecipeListNetworkModule::class
        ]
    )
    abstract fun contributeRecipeListActivity(): RecipeListActivity
}