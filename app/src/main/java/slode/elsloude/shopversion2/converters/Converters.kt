package slode.elsloude.shopversion2.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import slode.elsloude.shopversion2.pojo.Category

object Converters{
    @TypeConverter
    fun listCategoryToString(category: List<Category>) {
        Gson().toJson(category)
    }

//    @TypeConverter
//    fun StringToListCategories(CategoryToString: String): List<Category> {
//        val gson = GsonBuilder().create()
//        val objects = gson.fromJson(CategoryToString, List::class.java)
//        var category: ArrayList<Category>
//        for (i in objects) {
//            category.add(gson.fromJson(i.toString(), Category::class.java))
//        }
//        return category
//    }
}


