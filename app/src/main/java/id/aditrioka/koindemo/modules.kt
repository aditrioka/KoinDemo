package id.aditrioka.koindemo

import com.google.gson.Gson
import id.aditrioka.koindemo.data.DataRepository
import id.aditrioka.koindemo.data.DataRepositoryImpl
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }

    factory { CurrenciesAdapter() }
    factory<DataRepository> { DataRepositoryImpl(get()) }
}