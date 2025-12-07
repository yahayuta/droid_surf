package droid.surf

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SurfRecordDao {
    @Query("SELECT * FROM surf_records ORDER BY ymd DESC")
    fun getAll(): Flow<List<SurfRecordEntity>>

    @Insert
    fun insert(record: SurfRecordEntity)

    @Update
    fun update(record: SurfRecordEntity)

    @Query("DELETE FROM surf_records WHERE date = :date")
    fun delete(date: String)

    @Query("DELETE FROM surf_records")
    fun deleteAll()
}
