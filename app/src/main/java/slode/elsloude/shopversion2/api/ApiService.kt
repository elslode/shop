package slode.elsloude.shopversion2.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import slode.elsloude.shopversion2.pojo.CategoryInfoListOfData

interface ApiService{

    @GET("api/v1/products")
    fun getProductsInfo(
        @Query(QUERY_PARAM_MAXITEMS) maxItems: Int = 200,
        @Query(QUERY_PARAM_SORT) sort: String = CURRENCY
    ): Single<CategoryInfoListOfData>



    companion object {
        private const val QUERY_PARAM_MAXITEMS = "maxItems"
        private const val QUERY_PARAM_SORT = "sort"

        private const val CURRENCY = "title"
    }
}