package by.dzmitrey.danilau.foodrecipies.network

import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeResponse
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSerchResponse
import by.dzmitrey.danilau.foodrecipies.util.API_KEY
import by.dzmitrey.danilau.foodrecipies.util.API_KEY2
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/search")
    fun serchRecipe(
        @Query("key") key: String = API_KEY2,
        @Query("q") query: String,
        @Query("page") page:Int
    ): Observable<RecipeSerchResponse>

    @GET("api/get")
    fun getRecipes(
        @Query("key") key: String = API_KEY,
        @Query("rId") id: Int
    ): Observable<RecipeResponse>

}