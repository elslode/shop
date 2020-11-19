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

    fun loadData() {
        val disposable = ApiFactory.apiService.getProductsInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val a = it.data?.map { it.id}?.joinToString { "," }
                Log.d("TEST_OF_LOADING_DATA", it.toString())
            }, {
                Log.d("TEST_OF_LOADING_DATA", it.message.toString())
            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}