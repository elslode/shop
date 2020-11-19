package slode.elsloude.shopversion2.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryInfoListOfData (
    @SerializedName("data")
    @Expose
    val data: List<ProductInfo>? = null
)