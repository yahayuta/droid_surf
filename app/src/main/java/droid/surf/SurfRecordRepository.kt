package droid.surf

import androidx.annotation.WorkerThread

class SurfRecordRepository(private val surfRecordDao: SurfRecordDao) {

    val allRecords = surfRecordDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(record: SurfRecordEntity) {
        surfRecordDao.insert(record)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(record: SurfRecordEntity) {
        surfRecordDao.update(record)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(date: String) {
        surfRecordDao.delete(date)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAll() {
        surfRecordDao.deleteAll()
    }
}
