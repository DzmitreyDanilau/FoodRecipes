package by.dzmitrey.danilau.foodrecipies.adapters

interface OnCategoriesListener {

    interface OnCategoryListener{
        fun onCategoryClick(category: String)
    }
    interface OnSubCategoryListener{
        fun onSubCategoryClick(subCategory: String)
    }
}
