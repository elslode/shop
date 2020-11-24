package slode.elsloude.shopversion2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import slode.elsloude.shopversion2.api.ApiFactory
import slode.elsloude.shopversion2.database.AppDatabase

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val priceList = db.productPriceInfoDao().getPriceList()

    init {
        loadData()
    }

    private fun loadData() {
        val disposable = ApiFactory.apiService.getProductsInfo(maxItems = 200)
            .map { it.data?.map { it.id }?.joinToString (",") }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {

            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}