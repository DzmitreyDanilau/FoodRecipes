package by.dzmitrey.danilau.foodrecipies.di.modules

import by.dzmitrey.danilau.foodrecipies.di.scopes.ActivityScope
import by.dzmitrey.danilau.foodrecipies.ui.activities.RecipeListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
        ]
    )
    abstract fun contributeRecipeListActivity(): RecipeListActivity

}

