package by.dzmitrey.danilau.foodrecipies.network

import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeResponse
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSerchResponse
import by.dzmitrey.danilau.foodrecipies.util.API_KEY
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/search")
    fun serchRecipe(
        @Query("key") key: String = by.dzmitrey.danilau.foodrecipies.util.API_KEY2,
        @Query("q") query: String,
        @Query("page") page: Int
    ): Observable<RecipeSerchResponse>

    @GET("api/get")
    fun getRecipes(
        @Query("key") key: String = API_KEY,
        @Query("rId") id: Int
    ): Observable<RecipeResponse>

    companion object {
        fun get (okHttpClient: OkHttpClient): RecipeApi {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(by.dzmitrey.danilau.foodrecipies.util.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RecipeApi::class.java)
        }
    }
}