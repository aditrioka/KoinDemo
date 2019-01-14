package id.aditrioka.koindemo.data

import id.aditrioka.koindemo.model.Currency

interface DataRepository {

    fun getCurrencies(jsonString: String): List<Currency>
}