package by.dzmitrey.danilau.foodrecipies.di.modules

import by.dzmitrey.danilau.foodrecipies.RecipeListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeRecipeListActivity(): RecipeListActivity
}