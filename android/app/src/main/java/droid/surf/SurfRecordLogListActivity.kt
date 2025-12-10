package droid.surf

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import droid.surf.databinding.SubBinding

class SurfRecordLogListActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var resultList: List<SurfRecordEntity>? = null
    private lateinit var binding: SubBinding

    private val surfRecordViewModel: SurfRecordViewModel by viewModels {
        SurfRecordViewModelFactory((application as SurfApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        surfRecordViewModel.allRecords.observe(this) { records ->
            resultList = records
            makeRecordLogListView(records)
        }
    }

    private fun makeRecordLogListView(records: List<SurfRecordEntity>) {
        val viewList: MutableList<String> = ArrayList()
        if (records.isNullOrEmpty()) {
            viewList.add("NO DATA")
        } else {
            for (surfRecordEntity in records) {
                var text = ""
                val year = surfRecordEntity.ymd!!.substring(0, 4)
                val mon = surfRecordEntity.ymd!!.substring(4, 6)
                val day = surfRecordEntity.ymd!!.substring(6, 8)
                var monValue = mon.toInt()
                monValue = monValue + 1
                text = text + getString(R.string.log_date) + year + "/" + monValue + "/" + day + "\n"
                val h = surfRecordEntity.startTime!!.substring(0, 2)
                val m = surfRecordEntity.startTime!!.substring(2, 4)
                text = text + getString(R.string.log_time) + h + ":" + m + "\n"
                text = text + getString(R.string.log_hours) + surfRecordEntity.time + "\n"
                text = text + getString(R.string.log_point) + surfRecordEntity.pointName + "\n"
                text = text + getString(R.string.log_weather) + surfRecordEntity.weather + "\n"
                text = text + getString(R.string.log_wind) + surfRecordEntity.wind + "\n"
                text = text + getString(R.string.log_size) + surfRecordEntity.size + "\n"
                text = text + getString(R.string.log_crowd) + surfRecordEntity.cloud + "\n"
                text = text + getString(R.string.log_board) + surfRecordEntity.boardType + "\n"
                text = text + getString(R.string.log_takeoff) + surfRecordEntity.takeOff + "\n"
                text = text + getString(R.string.log_comment) + surfRecordEntity.comment
                viewList.add(text)
            }
        }
        // 記録ログリスト表示リストを画面に表示
        val lv = ListView(this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, viewList.toTypedArray())
        lv.adapter = adapter
        binding.statLayout.removeAllViews()
        binding.statLayout.addView(lv)
        // リスナー登録
        lv.onItemClickListener = this
    }

    override fun onItemClick(arg0: AdapterView<*>?, arg1: View, arg2: Int, arg3: Long) {
        if (resultList == null || resultList!!.isEmpty()) {
            return
        }
        var msg: String? = null
        val surfRecordEntity = resultList!![arg2]
        val year = surfRecordEntity.ymd!!.substring(0, 4)
        val mon = surfRecordEntity.ymd!!.substring(4, 6)
        val day = surfRecordEntity.ymd!!.substring(6, 8)
        var monValue = mon.toInt()
        monValue = monValue + 1
        msg = getString(R.string.log_date) + year + "/" + monValue + "/" + day + " "
        val h = surfRecordEntity.startTime!!.substring(0, 2)
        val m = surfRecordEntity.startTime!!.substring(2, 4)
        msg = msg + getString(R.string.log_time) + h + ":" + m + " "
        msg = msg + getString(R.string.log_hours) + surfRecordEntity.time + " "
        msg = msg + getString(R.string.log_point) + surfRecordEntity.pointName + " "
        msg = msg + getString(R.string.log_wind) + surfRecordEntity.wind + " "
        msg = msg + getString(R.string.log_size) + surfRecordEntity.size + " "
        msg = msg + getString(R.string.log_crowd) + surfRecordEntity.cloud + " "
        msg = msg + getString(R.string.log_takeoff) + surfRecordEntity.takeOff + " "
        msg = msg + getString(R.string.log_hash)
        // 外部アプリへ記録を送信
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TITLE, getString(R.string.app_name))
        intent.putExtra(Intent.EXTRA_TEXT, msg)
        startActivity(Intent.createChooser(intent, getString(R.string.log_title)))
    }
}