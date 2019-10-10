package by.dzmitrey.danilau.foodrecipies.network

import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeResponse
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSerchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/search")
    fun serchRecipe(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("page") page: String
    ): Single<RecipeSerchResponse>

    @GET("api/get")
    fun getRecipe(
        @Query("key") key: String,
        @Query("rId") id: Int
    ): Single<RecipeResponse>

}