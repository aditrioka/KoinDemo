package id.aditrioka.koindemo

import java.util.concurrent.ThreadLocalRandom

object DataFactory {

    fun randomString(): String {
        return java.util.UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }
}