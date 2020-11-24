package slode.elsloude.shopversion2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import slode.elsloude.shopversion2.R
import slode.elsloude.shopversion2.pojo.ProductInfo

class ProductInfoAdapter(private val context: Context) : RecyclerView.Adapter<ProductInfoAdapter.ProductViewHolder>() {

    var productInfoList: List<ProductInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onProductClickListener: OnProductClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cards_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product =productInfoList[position]
        with(holder){
            with(product) {
                textViewNameProduct.text = title.toString()
                textViewProducer.text = producer.toString()
                textViewPrice.text = amount.toString()
                Picasso.get().load(imageUrl).into(holder.ivProduct)

                itemView.setOnClickListener{
                    onProductClickListener?.onProductClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int = productInfoList.size

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProduct = itemView.findViewById<ImageView>(R.id.imageViewProduct)
        val ivAddToCart = itemView.findViewById<ImageView>(R.id.imageViewAddToCart)
        val textViewCategory = itemView.findViewById<TextView>(R.id.textViewCategory)
        val textViewNameProduct = itemView.findViewById<TextView>(R.id.textViewNameProduct)
        val textViewProducer = itemView.findViewById<TextView>(R.id.textViewProducer)
        val textViewPrice = itemView.findViewById<TextView>(R.id.textViewPrice)
    }

    interface OnProductClickListener{
        fun onProductClick(ProductInfo: ProductInfo)
    }
}


