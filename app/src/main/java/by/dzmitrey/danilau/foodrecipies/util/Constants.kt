package by.dzmitrey.danilau.foodrecipies.util

/*
Old API
const val BASE_URL = "https://www.food2fork.com/"
 */

const val BASE_URL = "https://api.spoonacular.com/"

const val API_KEY = "c0ea0491c8d9455fbda0944013f1aee7"

const val DATA_BASE_NAME = "recipes"

val DEFAULT_SEARCH_CATEGORIES = arrayOf(
    "African",
    "American",
    "European"

//    //Indian
//    "Indian",
//    //Asian
//    "Chinese",
//    "Korean",
//    "Japanese",
//    "Thai",
//    "Jewish",
//    "Vietnamese",
//    //"Mediterranean"
//    "Mediterranean"
)

val DEFAULT_SUB_CATEGORIES = mapOf(
    Pair("African",listOf("african")),
    Pair("American",listOf("american","mexican")),
    Pair("European",listOf("european","british","french","german","irish","italian","spanish"))
    )

val DEFAULT_SEARCH_CATEGORY_IMAGES = arrayOf(
    //African
    "african",
    //American
    "american",
    "european",
    "mexican",
    //EUROPEAN
    "british",
    "french",
    "german",
    "greek",
    "irish",
    "italian",
    "spanish"
//
//    //Indian
//    "Indian",
//    //Asian
//    "Chinese",
//    "Korean",
//    "Japanese",
//    "Thai",
//    "Jewish",
//    "Vietnamese",
//    //"Mediterranean"
//    "Mediterranean"
)
