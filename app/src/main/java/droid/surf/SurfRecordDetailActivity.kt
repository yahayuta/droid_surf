package droid.surf

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import droid.surf.databinding.SubBinding

class SurfRecordDetailActivity : AppCompatActivity() {

    private lateinit var binding: SubBinding

    private val surfRecordViewModel: SurfRecordViewModel by viewModels {
        SurfRecordViewModelFactory((application as SurfApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        surfRecordViewModel.allRecords.observe(this) { records ->
            makeRecordStatListView(records)
        }
    }

    private fun makeRecordStatListView(resultList: List<SurfRecordEntity>) {
        val viewList: MutableList<String> = ArrayList()
        if (resultList.isEmpty()) {
            viewList.add("NO DATA")
        } else {
            var hours = 0.0
            var takeOff = 0
            for (surfRecordEntity in resultList) {
                hours += surfRecordEntity.time!!.toDouble()
                takeOff += surfRecordEntity.takeOff!!.toInt()
            }
            viewList.add(getString(R.string.detail_num_surf) + resultList.size)
            viewList.add(getString(R.string.detail_time) + hours)
            viewList.add(getString(R.string.detail_takeoff) + takeOff)
            viewList.add(getString(R.string.detail_ave_time) + (hours / resultList.size).toString())
            viewList.add(getString(R.string.detail_ave_takeoff) + takeOff / resultList.size)
            // 何分おきにテイクオフできているか
            val takeOffRate = hours * 60 / takeOff
            viewList.add(getString(R.string.detail_takeoff_rate) + takeOffRate.toString() + getString(R.string.detail_takeoff_rate_msg))
        }
        // 統計表示リストを画面に表示
        val lv = ListView(this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, viewList.toTypedArray())
        lv.adapter = adapter
        binding.statLayout.removeAllViews()
        binding.statLayout.addView(lv)
    }
}