package slode.elsloude.shopversion2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import slode.elsloude.shopversion2.adapter.ProductInfoAdapter
import slode.elsloude.shopversion2.pojo.ProductInfo
@Suppress("DEPRECATION")
class ProductPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_price_list)
        val adapter = ProductInfoAdapter(this)

        adapter.onProductClickListener = object : ProductInfoAdapter.OnProductClickListener {
            override fun onProductClick(ProductInfo: ProductInfo) {
                val intent = ProductDetailActivity.newIntent(
                    this@ProductPriceListActivity,
                    ProductInfo.id
                )
                startActivity(intent)
            }
        }

        val recyclerViewProducts = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerViewProducts.adapter = adapter
        viewModel = ViewModelProviders.of(this)[ProductViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            adapter.productInfoList = it
        })
    }
}