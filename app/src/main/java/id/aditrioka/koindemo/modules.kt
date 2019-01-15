package id.aditrioka.koindemo

import com.google.gson.Gson
import id.aditrioka.koindemo.data.DataRepository
import id.aditrioka.koindemo.data.DataRepositoryFactory
import id.aditrioka.koindemo.data.LocalDataRepository
import id.aditrioka.koindemo.data.RemoteDataRepository
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }

    factory { CurrenciesAdapter() }

    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }

    factory { DataRepositoryFactory(get("local"), get("remote")) }
}