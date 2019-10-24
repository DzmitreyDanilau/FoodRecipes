package by.dzmitrey.danilau.foodrecipies.di.components

import android.app.Application
import by.dzmitrey.danilau.foodrecipies.RecipeListApp
import by.dzmitrey.danilau.foodrecipies.di.modules.*
import by.dzmitrey.danilau.foodrecipies.di.scopes.ApplicationScope
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
        RecipeViewModelModule::class,
        RoomModule::class
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