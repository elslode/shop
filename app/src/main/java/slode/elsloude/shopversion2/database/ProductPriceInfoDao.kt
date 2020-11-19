package slode.elsloude.shopversion2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import slode.elsloude.shopversion2.pojo.ProductInfo

@Dao
interface ProductPriceInfoDao {
    @Query("SELECT * FROM full_price_list ORDER BY title")
    fun getPriceList() : LiveData<List<ProductInfo>>

    @Query("SELECT * FROM full_price_list WHERE id = :pInfo LIMIT 1")
    fun getPriceInfoAboutOneProduct(pInfo: String): LiveData<List<ProductInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductList(productList: List<ProductInfo>)
}