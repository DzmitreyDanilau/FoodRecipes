package by.dzmitrey.danilau.foodrecipies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.dzmitrey.danilau.foodrecipies.interactors.IInteractor
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.models.backend.RecipeApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(
    private val recipeListInteractor: IInteractor.RecipeListInteractor
) :
    ViewModel() {
    private var isViewCategories: Boolean = false
    private val recipesList: MutableLiveData<List<RecipeLocal>> = MutableLiveData()
    private val recipesListError: MutableLiveData<String> = MutableLiveData()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun searchRecipes(query: String, page: Int) {
        isViewCategories = true
        compositeDisposable.add(
            recipeListInteractor.fetchDataFromApi(query, page)
                .subscribeOn(Schedulers.newThread())
                .doOnSuccess {
                    Timber.d("Thread Search recipes: ${Thread.currentThread().name}")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Timber.d("In Subscribe: ${Thread.currentThread().name}")
                        recipesList.value = it
                    },
                    {
                        Timber.d("${it.message}")
                        recipesListError.value = it.message
                    })
        )
    }

    fun getRecipesList(): LiveData<List<RecipeLocal>> = recipesList
    fun getRecipesListError(): LiveData<String> = recipesListError
    fun isViewRecipes() = isViewCategories
    fun setIsViewRecipes(isViewRecipes: Boolean) {
        isViewCategories = isViewRecipes
    }

}

//TODO change type of recipesList to RecipeLocal