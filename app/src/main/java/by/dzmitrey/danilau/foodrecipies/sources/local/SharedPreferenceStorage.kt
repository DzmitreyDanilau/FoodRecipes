package by.dzmitrey.danilau.foodrecipies.sources.local

import android.app.Application
import android.content.Context
import io.reactivex.Observable
import javax.inject.Inject

class SharedPreferenceStorage @Inject constructor(val application: Application) :
    ILocalStorage.SharedPreferencesStorage {
    override fun readData(): Observable<String> {
        return Observable.fromCallable {
            return@fromCallable application.applicationContext.getSharedPreferences(
                "SPref",
                Context.MODE_PRIVATE
            ).getString("login", null)
        }
    }

    override fun writeData(data: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}