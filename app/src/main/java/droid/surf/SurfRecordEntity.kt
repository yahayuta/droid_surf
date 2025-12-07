package droid.surf

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "surf_records")
data class SurfRecordEntity(
    @PrimaryKey
    var date: String,
    var ymd: String? = null,
    var startTime: String? = null,
    var time: String? = null,
    var pointName: String? = null,
    var weather: String? = null,
    var wind: String? = null,
    var size: String? = null,
    var cloud: String? = null,
    var boardType: String? = null,
    var takeOff: String? = null,
    var comment: String? = null
)
