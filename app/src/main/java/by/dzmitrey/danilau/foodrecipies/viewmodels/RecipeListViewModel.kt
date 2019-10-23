package by.dzmitrey.danilau.foodrecipies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.dzmitrey.danilau.foodrecipies.interactors.IInteractor
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(private val recipeListInteractor: IInteractor.RecipeListInteractor) :
    ViewModel() {
    private val recipesList: MutableLiveData<List<RecipeLocal>> = MutableLiveData()
    private val recipesListError: MutableLiveData<String> = MutableLiveData()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun searchRecipes(query: String, page: Int) {
        compositeDisposable.add(
            recipeListInteractor.fetchDataFromApi(query, page)
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

    fun getRecipesList(): LiveData<List<RecipeLocal>> = recipesList
    fun getRecipesListError(): LiveData<String> = recipesListError
}