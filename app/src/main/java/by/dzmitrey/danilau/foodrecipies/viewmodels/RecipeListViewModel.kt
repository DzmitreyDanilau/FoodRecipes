package by.dzmitrey.danilau.foodrecipies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.dzmitrey.danilau.foodrecipies.models.Recipe
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(private val repository: RecipeListRepository) :
    ViewModel() {
    private val recipesList: MutableLiveData<Recipe> = MutableLiveData()
    private val recipesListError: MutableLiveData<String> = MutableLiveData()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun searchRecipes(query: String, page: Int) {
        compositeDisposable.add(
            repository.searchRecipes(query, page)
                .map {
                    Timber.d("${it[0]}")
                    it[0]

                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        recipesList.postValue(it)
                    },
                    {
                        recipesListError.postValue(it.message)
                    })
        )
    }

    fun getRecipesList(): LiveData<Recipe> = recipesList
    fun getRecipesListError(): LiveData<String> = recipesListError
}