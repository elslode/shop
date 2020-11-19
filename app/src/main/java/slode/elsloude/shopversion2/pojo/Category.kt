package slode.elsloude.shopversion2.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("parent_id")
    @Expose
    val parentId: Int
)
