package by.dzmitrey.danilau.foodrecipies.models.app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = by.dzmitrey.danilau.foodrecipies.util.DATA_BASE_NAME)
data class RecipeLocal(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "rId")
    val rId: Int,
    @ColumnInfo(name = "publisher")
    val publisher: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "ingredients")
    val ingredients: List<String?>,
    @ColumnInfo(name = "id")
    val id: String?,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String?,
    @ColumnInfo(name = "socialRank")
    val socialRank: Int
)