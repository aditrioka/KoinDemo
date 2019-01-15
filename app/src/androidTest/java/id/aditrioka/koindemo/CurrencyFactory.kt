package id.aditrioka.koindemo

import id.aditrioka.koindemo.model.Currency

object CurrencyFactory {

    fun makeCurrency(): Currency {
        return Currency(DataFactory.randomInt(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeCurrencyList(count: Int): List<Currency> {
        return (0..count).map { makeCurrency() }
    }
}