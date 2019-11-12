package by.dzmitrey.danilau.foodrecipies.di.modules

import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListInteractorsModule
import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListNetworkModule
import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListRepositoriesModule
import by.dzmitrey.danilau.foodrecipies.di.scopes.FragmentScope
import by.dzmitrey.danilau.foodrecipies.ui.fragments.RecipeCategoryFragment
import by.dzmitrey.danilau.foodrecipies.ui.fragments.RecipesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeRecipeCategoryFragment(): RecipeCategoryFragment

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            RecipeViewModelModule::class,
            RecipeListRepositoriesModule::class,
            RecipeListNetworkModule::class,
            RecipeListInteractorsModule::class
        ]
    )
    abstract fun contributeRecipeListFragment(): RecipesListFragment
}