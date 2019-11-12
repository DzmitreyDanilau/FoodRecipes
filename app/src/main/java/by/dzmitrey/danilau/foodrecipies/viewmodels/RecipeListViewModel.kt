package by.dzmitrey.danilau.foodrecipies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.dzmitrey.danilau.foodrecipies.interactors.IInteractor
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(
    private val recipeListInteractor: IInteractor.RecipeListInteractor
) :
    ViewModel() {
    private var isViewRecipes: Boolean = false
    private val recipesList: MutableLiveData<List<RecipeLocal>> = MutableLiveData()
    private val recipesListError: MutableLiveData<String> = MutableLiveData()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun searchRecipes(query: String, page: Int) {
        compositeDisposable.add(
            recipeListInteractor.fetchData(query, page)
                .subscribeOn(Schedulers.newThread())
                .doOnComplete {
                    Timber.d("Thread Search recipes: ${Thread.currentThread().name}")
                }
                .observeOn(Schedulers.io())
                .subscribe(
                    {
                        Timber.d("In Subscribe: ${Thread.currentThread().name}")
                        recipesList.postValue(it)
                    },
                    {
                        Timber.d("${it.message}")
                        recipesListError.postValue(it.message)
                    })
        )
    }

    fun getRecipesList(): LiveData<List<RecipeLocal>> = recipesList
    fun getRecipesListError(): LiveData<String> = recipesListError
    fun onBackPressed(): Boolean {
        return if (isViewRecipes) {
            isViewRecipes = false
            false
        } else {
            true
        }
    }

}

//TODO change type of recipesList to RecipeLocal