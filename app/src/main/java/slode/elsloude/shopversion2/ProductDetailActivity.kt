package slode.elsloude.shopversion2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
    }

    companion object {
        fun newIntent(context: Context, id: Int?): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            return intent
        }
    }
}