package by.dzmitrey.danilau.foodrecipies.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.dzmitrey.danilau.foodrecipies.models.Recipe
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListRepository
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(private val repository: RecipeListRepository) :
    ViewModel() {
    val recipesList: MutableLiveData<List<Recipe>> = MutableLiveData()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun searchRecipes(query: String, page: Int) {
        compositeDisposable.add(
            repository.searchRecipes(query, page)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                    recipesList.postValue(it.recipesList)
                })
    }

    fun getRecipes(query: String, page: Int) = repository.searchRecipes(query, page)
}