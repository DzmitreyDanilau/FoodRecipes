package by.dzmitrey.danilau.foodrecipies.di.components

import android.app.Application
import by.dzmitrey.danilau.foodrecipies.RecipeListApp
import by.dzmitrey.danilau.foodrecipies.di.modules.ActivityBuilderModule
import by.dzmitrey.danilau.foodrecipies.di.modules.AppModule
import by.dzmitrey.danilau.foodrecipies.di.modules.NetworkModule
import by.dzmitrey.danilau.foodrecipies.di.modules.RecipeViewModelModule
import by.dzmitrey.danilau.foodrecipies.di.recipelist.RecipeListRepositoryModule
import by.dzmitrey.danilau.foodrecipies.di.scopes.ApplicationScope
import by.dzmitrey.danilau.foodrecipies.viewmodels.RecipeListViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        NetworkModule::class,
        RecipeViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<RecipeListApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}