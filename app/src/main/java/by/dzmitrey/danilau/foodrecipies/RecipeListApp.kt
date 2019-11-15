package by.dzmitrey.danilau.foodrecipies

import by.dzmitrey.danilau.foodrecipies.di.components.DaggerAppComponent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class RecipeListApp : DaggerApplication() {
    lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        val googleSigninOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this,googleSigninOptions)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}