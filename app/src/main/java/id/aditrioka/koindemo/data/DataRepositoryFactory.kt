package id.aditrioka.koindemo.data

class DataRepositoryFactory constructor(
    private val localDataRepository: DataRepository,
    private val remotedataRepository: DataRepository) {

    fun retrieveRemoteSource(): DataRepository {
        return remotedataRepository
    }

    fun retrieveLocalSource(): DataRepository {
        return localDataRepository
    }
}