package id.aditrioka.koindemo

import com.google.gson.Gson
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
}