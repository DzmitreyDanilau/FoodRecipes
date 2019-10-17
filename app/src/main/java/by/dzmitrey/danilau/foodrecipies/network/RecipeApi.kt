package by.dzmitrey.danilau.foodrecipies.network

import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeResponse
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import by.dzmitrey.danilau.foodrecipies.util.API_KEY
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/search")
    fun searchRecipes(
        @Query("key") key: String = by.dzmitrey.danilau.foodrecipies.util.API_KEY2,
        @Query("q") query: String,
        @Query("page") page: Int
    ): Observable<RecipeSearchResponse>

    @GET("api/get")
    fun getRecipes(
        @Query("key") key: String = API_KEY,
        @Query("rId") id: Int
    ): Observable<RecipeResponse>

    companion object {
        fun get(retrofit: Retrofit): RecipeApi {
            return retrofit.create(RecipeApi::class.java)
        }
    }
}