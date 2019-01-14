package id.aditrioka.koindemo.data

import com.google.gson.Gson
import id.aditrioka.koindemo.model.Currency

open class DataRepositoryImpl(private val gson: Gson) : DataRepository {

    override fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }

}