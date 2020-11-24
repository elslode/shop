package slode.elsloude.shopversion2.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import slode.elsloude.shopversion2.converters.Converters

@Entity(tableName = "full_price_list")
//@TypeConverters(Converters::class)
data class ProductInfo(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("title")
    @Expose
    val title: String? = null,
    @SerializedName("short_description")
    @Expose
    val shortDescription: String? = null,
    @SerializedName("image_url")
    @Expose
    val imageUrl: String? = null,
    @SerializedName("amount")
    @Expose
    val amount: Int? = null,
    @SerializedName("price")
    @Expose
    val price: Double? = null,
    @SerializedName("producer")
    @Expose
    val producer: String? = null
//    @SerializedName("category")
//    @Expose
//    val categories: List<Category>? = null
)