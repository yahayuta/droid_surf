package droid.surf

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [SurfRecordEntity::class], version = 2, exportSchema = false)
abstract class SurfLogDatabase : RoomDatabase() {

    abstract fun surfRecordDao(): SurfRecordDao

    companion object {
        @Volatile
        private var INSTANCE: SurfLogDatabase? = null

        fun getDatabase(context: Context): SurfLogDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SurfLogDatabase::class.java,
                    "SurfRecord"
                )
                .addMigrations(MIGRATION_1_2)
                .build()
                INSTANCE = instance
                instance
            }
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `surf_records` (`date` TEXT NOT NULL, `ymd` TEXT, `startTime` TEXT, `time` TEXT, `pointName` TEXT, `weather` TEXT, `wind` TEXT, `size` TEXT, `cloud` TEXT, `boardType` TEXT, `takeOff` TEXT, `comment` TEXT, PRIMARY KEY(`date`))")
                database.execSQL("INSERT INTO surf_records (date, ymd, startTime, time, pointName, weather, wind, size, cloud, boardType, takeOff, comment) SELECT date, ymd, startTime, time, pointName, weather, wind, size, cloud, boardType, takeOff, comment FROM SurfRecord")
                database.execSQL("DROP TABLE SurfRecord")
            }
        }
    }
}
