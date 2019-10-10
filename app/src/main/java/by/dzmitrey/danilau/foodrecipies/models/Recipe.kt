package by.dzmitrey.danilau.foodrecipies.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("title")
    private val title: String?,
    @SerializedName("publisher")
    private val publisher: String?,
    @SerializedName("ingredients")
    private val ingredients: ArrayList<String>,
    @SerializedName("recipe_id")
    private val id: Int,
    @SerializedName("image_url")
    private val imageUrl: String?,
    @SerializedName("social_rank")
    private val socialRank: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        TODO("ingredients"),
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble()
    )

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}



