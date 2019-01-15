package id.aditrioka.koindemo

import com.google.gson.Gson
import id.aditrioka.koindemo.data.DataRepository
import id.aditrioka.koindemo.data.DataRepositoryFactory
import id.aditrioka.koindemo.data.LocalDataRepository
import id.aditrioka.koindemo.data.RemoteDataRepository
import id.aditrioka.koindemo.presentation.CurrenciesAdapter
import id.aditrioka.koindemo.presentation.CurrenciesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    single { UrlHelper(getProperty("currency_base_url")) }

    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }

    factory { DataRepositoryFactory(get("local"), get("remote")) }
}

val browseModule = module("browse") {
    viewModel { (jsonString: String) -> CurrenciesViewModel(get(), jsonString) }
    factory { CurrenciesAdapter() }
}