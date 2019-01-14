package id.aditrioka.koindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.aditrioka.koindemo.data.DataRepository
import id.aditrioka.koindemo.data.DataRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val currenciesAdapter: CurrenciesAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCurrenciesRecycler()

        val dataResository = get<DataRepository>()
        val currenciesJson = resources.openRawResource(R.raw.currencies)
            .bufferedReader().use { it.readText() }
        val item = dataResository.getCurrencies(currenciesJson)
        currenciesAdapter.currencies = item
    }

    private fun setupCurrenciesRecycler() {
        recycler_currencies.layoutManager = LinearLayoutManager(this)
        recycler_currencies.adapter = currenciesAdapter
    }
}
