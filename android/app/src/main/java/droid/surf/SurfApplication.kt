package droid.surf

import android.app.Application

class SurfApplication : Application() {
    val database by lazy { SurfLogDatabase.getDatabase(this) }
    val repository by lazy { SurfRecordRepository(database.surfRecordDao()) }
}
