package by.dzmitrey.danilau.foodrecipies.models.app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import by.dzmitrey.danilau.foodrecipies.models.BaseRecipe
import org.jetbrains.annotations.NotNull

@Entity(tableName = by.dzmitrey.danilau.foodrecipies.util.DATA_BASE_NAME)
data class RecipeLocal(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "rId")
    var rId: Int,
    @ColumnInfo(name = "publisher")
    val publisher: String?,
    @ColumnInfo(name = "title")
    override val title: String?,
    @ColumnInfo(name = "ingredients")
    val ingredients: List<String?>?,
    @ColumnInfo(name = "id")
    override val id: String,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String?,
    @ColumnInfo(name = "socialRank")
    val socialRank: Int
) : BaseRecipe