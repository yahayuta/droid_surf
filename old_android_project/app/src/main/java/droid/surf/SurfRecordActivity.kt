package droid.surf

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import droid.surf.databinding.MainBinding

class SurfRecordActivity : AppCompatActivity(), View.OnClickListener, DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener {

    private val MENU_ITEM0 = 0
    private val MENU_ITEM2 = 2
    private val MENU_ITEM3 = 3
    private val MENU_ITEM4 = 4
    private val MENU_ITEM5 = 5
    private val MENU_ITEM6 = 6

    private val WEATHER_VALUE_LIST: MutableList<String> = ArrayList()
    private val WEATHER_VALUE_MAP: MutableMap<String, String> = HashMap()

    private val WIND_VALUE_LIST: MutableList<String> = ArrayList()
    private val WIND_VALUE_MAP: MutableMap<String, String> = HashMap()

    private val SIZE_VALUE_LIST: MutableList<String> = ArrayList()
    private val SIZE_VALUE_MAP: MutableMap<String, String> = HashMap()

    private val CROWD_VALUE_LIST: MutableList<String> = ArrayList()
    private val CROWD_VALUE_MAP: MutableMap<String, String> = HashMap()

    private val TYPE_VALUE_LIST: MutableList<String> = ArrayList()
    private val TYPE_VALUE_MAP: MutableMap<String, String> = HashMap()

    private var isReg = true
    private var dataList: List<SurfRecordEntity>? = null
    private var currentIndex = 0

    private lateinit var binding: MainBinding

    private val surfRecordViewModel: SurfRecordViewModel by viewModels {
        SurfRecordViewModelFactory((application as SurfApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        binding.timePickerStart.setIs24HourView(true)

        refreshSpinner()

        binding.buttonSave.setOnClickListener(this)
        binding.buttonFwd.setOnClickListener(this)
        binding.buttonRev.setOnClickListener(this)
        binding.buttonDel.setOnClickListener(this)

        surfRecordViewModel.allRecords.observe(this) { records ->
            dataList = records
            if (isReg) { // If in "add record" mode and records are empty, keep UI clear
                if (records.isEmpty()) {
                    initStatus()
                }
            } else { // If in "edit record" mode
                if (records.isEmpty()) { // If no records exist, switch to add mode
                    isReg = true
                    initStatus()
                } else { // Display records
                    updateStatus()
                }
            }
        }

        initStatus() // Initial UI setup
    }

    private fun init() {
        WEATHER_VALUE_LIST.add(getString(R.string.weather_fine))
        WEATHER_VALUE_LIST.add(getString(R.string.weather_cloud))
        WEATHER_VALUE_LIST.add(getString(R.string.weather_rain))
        WEATHER_VALUE_LIST.add(getString(R.string.weather_snow))
        for (i in WEATHER_VALUE_LIST.indices) {
            val array_element = WEATHER_VALUE_LIST[i]
            WEATHER_VALUE_MAP[array_element] = i.toString()
        }

        WIND_VALUE_LIST.add(getString(R.string.wind_none))
        WIND_VALUE_LIST.add(getString(R.string.wind_strong_off))
        WIND_VALUE_LIST.add(getString(R.string.wind_off))
        WIND_VALUE_LIST.add(getString(R.string.wind_weak_off))
        WIND_VALUE_LIST.add(getString(R.string.wind_strong_on))
        WIND_VALUE_LIST.add(getString(R.string.wind_on))
        WIND_VALUE_LIST.add(getString(R.string.wind_weak_on))
        WIND_VALUE_LIST.add(getString(R.string.wind_side_off))
        WIND_VALUE_LIST.add(getString(R.string.wind_side_on))
        for (i in WIND_VALUE_LIST.indices) {
            val array_element = WIND_VALUE_LIST[i]
            WIND_VALUE_MAP[array_element] = i.toString()
        }

        SIZE_VALUE_LIST.add(getString(R.string.size_flat))
        SIZE_VALUE_LIST.add(getString(R.string.size_ankle))
        SIZE_VALUE_LIST.add(getString(R.string.size_shin))
        SIZE_VALUE_LIST.add(getString(R.string.size_knee))
        SIZE_VALUE_LIST.add(getString(R.string.size_thigh))
        SIZE_VALUE_LIST.add(getString(R.string.size_waist))
        SIZE_VALUE_LIST.add(getString(R.string.size_belly))
        SIZE_VALUE_LIST.add(getString(R.string.size_chest))
        SIZE_VALUE_LIST.add(getString(R.string.size_shoulder))
        SIZE_VALUE_LIST.add(getString(R.string.size_head))
        SIZE_VALUE_LIST.add(getString(R.string.size_over_h))
        SIZE_VALUE_LIST.add(getString(R.string.size_double))
        SIZE_VALUE_LIST.add(getString(R.string.size_triple))
        SIZE_VALUE_LIST.add(getString(R.string.size_giant))
        for (i in SIZE_VALUE_LIST.indices) {
            val array_element = SIZE_VALUE_LIST[i]
            SIZE_VALUE_MAP[array_element] = i.toString()
        }

        CROWD_VALUE_LIST.add(getString(R.string.crowd_noone))
        CROWD_VALUE_LIST.add(getString(R.string.crowd_low))
        CROWD_VALUE_LIST.add(getString(R.string.crowd_normal))
        CROWD_VALUE_LIST.add(getString(R.string.crowd_high))
        CROWD_VALUE_LIST.add(getString(R.string.crowd_heavy))
        for (i in CROWD_VALUE_LIST.indices) {
            val array_element = CROWD_VALUE_LIST[i]
            CROWD_VALUE_MAP[array_element] = i.toString()
        }

        TYPE_VALUE_LIST.add(getString(R.string.board_short))
        TYPE_VALUE_LIST.add(getString(R.string.board_fun))
        TYPE_VALUE_LIST.add(getString(R.string.board_long))
        TYPE_VALUE_LIST.add(getString(R.string.board_sup))
        TYPE_VALUE_LIST.add(getString(R.string.board_gun))
        TYPE_VALUE_LIST.add(getString(R.string.board_bb))
        for (i in TYPE_VALUE_LIST.indices) {
            val array_element = TYPE_VALUE_LIST[i]
            TYPE_VALUE_MAP[array_element] = i.toString()
        }
    }

    private fun refreshSpinner() {
        val adapterWeather = ArrayAdapter(this, android.R.layout.simple_spinner_item, WEATHER_VALUE_LIST)
        adapterWeather.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerWeather.adapter = adapterWeather

        val adapterWind = ArrayAdapter(this, android.R.layout.simple_spinner_item, WIND_VALUE_LIST)
        adapterWind.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerWind.adapter = adapterWind

        val adapterSize = ArrayAdapter(this, android.R.layout.simple_spinner_item, SIZE_VALUE_LIST)
        adapterSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSize.adapter = adapterSize

        val adapterCloud = ArrayAdapter(this, android.R.layout.simple_spinner_item, CROWD_VALUE_LIST)
        adapterCloud.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCloud.adapter = adapterCloud

        val adapterType = ArrayAdapter(this, android.R.layout.simple_spinner_item, TYPE_VALUE_LIST)
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBoard.adapter = adapterType
    }

    override fun onClick(arg0: View) {
        when (arg0) {
            binding.buttonSave -> execBtnSave()
            binding.buttonFwd -> {
                currentIndex++
                updateStatus()
            }
            binding.buttonRev -> {
                currentIndex--
                updateStatus()
            }
            binding.buttonDel -> if (!isReg) {
                delete()
            }
        }
    }

    private fun initStatus() {
        // Clear all fields for new record or if no records exist in edit mode
        binding.editHours.setText("")
        binding.editTextPoint.setText("")
        binding.spinnerWeather.setSelection(0)
        binding.spinnerWind.setSelection(0)
        binding.spinnerSize.setSelection(0)
        binding.spinnerCloud.setSelection(0)
        binding.spinnerBoard.setSelection(0)
        binding.editTextTakeOff.setText("")
        binding.editComment.setText("")

        // Hide navigation and delete buttons for new record mode
        binding.buttonFwd.visibility = View.GONE
        binding.buttonRev.visibility = View.GONE
        binding.buttonDel.visibility = View.GONE
    }

    private fun updateStatus() {
        dataList?.let { records ->
            if (records.isNotEmpty()) {
                binding.buttonDel.visibility = View.VISIBLE

                if (currentIndex >= records.size) { // Adjust currentIndex if it's out of bounds
                    currentIndex = records.size - 1
                } else if (currentIndex < 0) {
                    currentIndex = 0
                }

                if (currentIndex + 1 >= records.size) {
                    binding.buttonFwd.visibility = View.GONE
                } else {
                    binding.buttonFwd.visibility = View.VISIBLE
                }

                if (currentIndex == 0) {
                    binding.buttonRev.visibility = View.GONE
                } else {
                    binding.buttonRev.visibility = View.VISIBLE
                }
                setData()
            } else { // No records exist
                isReg = true
                initStatus()
            }
        } ?: run { // dataList is null
            isReg = true
            initStatus()
        }
    }

    private fun setData() {
        val ymd = dataList!![currentIndex].ymd
        val year = ymd!!.substring(0, 4).toInt()
        val mon = ymd.substring(4, 6).toInt()
        val day = ymd.substring(6, 8).toInt()
        binding.datePickerDay.init(year, mon, day, this)
        val time = dataList!![currentIndex].startTime
        val h = time!!.substring(0, 2).toInt()
        val m = time.substring(2, 4).toInt()
        binding.timePickerStart.setCurrentHour(h)
        binding.timePickerStart.setCurrentMinute(m)
        binding.timePickerStart.setOnTimeChangedListener(this)
        binding.editHours.setText(dataList!![currentIndex].time)
        binding.editTextPoint.setText(dataList!![currentIndex].pointName)
        binding.spinnerWeather.setSelection(WEATHER_VALUE_MAP[dataList!![currentIndex].weather]!!.toInt())
        binding.spinnerWind.setSelection(WIND_VALUE_MAP[dataList!![currentIndex].wind]!!.toInt())
        binding.spinnerSize.setSelection(SIZE_VALUE_MAP[dataList!![currentIndex].size]!!.toInt())
        binding.spinnerCloud.setSelection(CROWD_VALUE_MAP[dataList!![currentIndex].cloud]!!.toInt())
        binding.spinnerBoard.setSelection(TYPE_VALUE_MAP[dataList!![currentIndex].boardType]!!.toInt())
        binding.editTextTakeOff.setText(dataList!![currentIndex].takeOff)
        binding.editComment.setText(dataList!![currentIndex].comment)
    }

    private fun execBtnSave() {
        val date = if (isReg) {
            System.currentTimeMillis().toString()
        } else {
            dataList!![currentIndex].date
        }
        val year = binding.datePickerDay.year
        val mon = binding.datePickerDay.month
        val day = binding.datePickerDay.dayOfMonth
        var ymd = year.toString()
        ymd += if (mon < 10) {
            "0$mon"
        } else {
            mon.toString()
        }
        ymd += if (day < 10) {
            "0$day"
        } else {
            day.toString()
        }
        val h = binding.timePickerStart.getCurrentHour()
        val m = binding.timePickerStart.getCurrentMinute()
        var hm = ""
        hm += if (h < 10) {
            "0$h"
        } else {
            h.toString()
        }
        hm += if (m < 10) {
            "0$m"
        } else {
            m.toString()
        }
        if (isNull(binding.editHours.text.toString(), getString(R.string.disp_time))) return
        if (!isInteger(binding.editHours.text.toString(), getString(R.string.disp_time))) return
        if (isNull(binding.editTextTakeOff.text.toString(), getString(R.string.disp_takeoff))) return
        if (!isInteger(binding.editTextTakeOff.text.toString(), getString(R.string.disp_takeoff))) return

        val record = SurfRecordEntity(
            date = date,
            ymd = ymd,
            startTime = hm,
            time = binding.editHours.text.toString(),
            pointName = binding.editTextPoint.text.toString(),
            weather = binding.spinnerWeather.selectedItem as String,
            wind = binding.spinnerWind.selectedItem as String,
            size = binding.spinnerSize.selectedItem as String,
            cloud = binding.spinnerCloud.selectedItem as String,
            boardType = binding.spinnerBoard.selectedItem as String,
            takeOff = binding.editTextTakeOff.text.toString(),
            comment = binding.editComment.text.toString()
        )

        if (isReg) {
            surfRecordViewModel.insert(record)
            // After insertion, stay in add mode and clear fields
            isReg = true
            initStatus()
        } else {
            surfRecordViewModel.update(record)
            // After update, stay in edit mode and refresh current record display
            isReg = false
            updateStatus()
        }
        val dlg = AlertDialog.Builder(this@SurfRecordActivity)
        dlg.setMessage(getString(R.string.msg_saved))
        dlg.setPositiveButton("OK", null)
        dlg.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        val actionItem0 = menu.add(0, MENU_ITEM0, 0, getString(R.string.menu_detail))
        actionItem0.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        val actionItem2 = menu.add(0, MENU_ITEM2, 0, getString(R.string.menu_add))
        actionItem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        val actionItem3 = menu.add(0, MENU_ITEM3, 0, getString(R.string.menu_edit))
        actionItem3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        val actionItem4 = menu.add(0, MENU_ITEM4, 0, getString(R.string.menu_loglist))
        actionItem4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        val actionItem5 = menu.add(0, MENU_ITEM5, 0, getString(R.string.menu_export))
        actionItem5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        val actionItem6 = menu.add(0, MENU_ITEM6, 0, getString(R.string.menu_reset))
        actionItem6.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_ITEM0 -> {
                val intent = Intent(this@SurfRecordActivity, SurfRecordDetailActivity::class.java)
                startActivity(intent)
                return true
            }
            MENU_ITEM2 -> { // Add Record
                isReg = true
                initStatus()
                return true
            }
            MENU_ITEM3 -> { // Edit Record
                isReg = false
                currentIndex = 0 // Start from the first record when entering edit mode
                updateStatus()
                return true
            }
            MENU_ITEM4 -> {
                val intent3 = Intent(this@SurfRecordActivity, SurfRecordLogListActivity::class.java)
                startActivity(intent3)
                return true
            }
            MENU_ITEM5 -> {
                exportRecordLog()
                return true
            }
            MENU_ITEM6 -> {
                val dlg = AlertDialog.Builder(this)
                dlg.setMessage(getString(R.string.msg_all_del_con))
                val listnerAllDel = DialogInterface.OnClickListener { _, _ ->
                    surfRecordViewModel.deleteAll()
                    currentIndex = 0
                    isReg = true
                    initStatus()
                }
                dlg.setPositiveButton("Yes", listnerAllDel)
                dlg.setNegativeButton("No", listnerAllDel)
                dlg.show()
                return true
            }
        }
        return true
    }

    private fun exportRecordLog() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        var text = ""
        // Use dataList if available, otherwise fetch
        dataList?.let { records ->
            for (data in records) {
                val year = data.ymd!!.substring(0, 4)
                val mon = data.ymd!!.substring(4, 6)
                val day = data.ymd!!.substring(6, 8)
                var monValue = mon.toInt()
                monValue += 1
                text += "$year/$monValue/$day,"
                val h = data.startTime!!.substring(0, 2)
                val m = data.startTime!!.substring(2, 4)
                text += "$h:$m,"
                text += "${data.time},"
                text += "${data.pointName},"
                text += "${data.weather},"
                text += "${data.wind},"
                text += "${data.size},"
                text += "${data.cloud},"
                text += "${data.boardType},"
                text += "${data.takeOff}\n"
            }
        }
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, getString(R.string.menu_exp_other)))
    }

    private fun delete() {
        val dlg = AlertDialog.Builder(this)
        dlg.setMessage(getString(R.string.msg_del_con))
        val listnerDel = DialogInterface.OnClickListener { dialog, which -> deleteSingle() }
        dlg.setPositiveButton("Yes", listnerDel)
        dlg.setNegativeButton("No", listnerDel)
        dlg.show()
    }

    private fun isInteger(num: String, data: String): Boolean {
        return try {
            num.toDouble()
            true
        } catch (e: NumberFormatException) {
            val dlg = AlertDialog.Builder(this)
            dlg.setMessage(data + getString(R.string.msg_need_number))
            dlg.setPositiveButton("OK", null)
            dlg.show()
            false
        }
    }

    private fun isNull(str: String?, data: String): Boolean {
        if (str == null || str.isEmpty()) {
            val dlg = AlertDialog.Builder(this)
            dlg.setMessage(data + getString(R.string.msg_no_null))
            dlg.setPositiveButton("OK", null)
            dlg.show()
            return true
        }
        return false
    }

    override fun onTimeChanged(arg0: TimePicker, arg1: Int, arg2: Int) { // TODO Auto-generated method stub
    }

    override fun onDateChanged(arg0: DatePicker, arg1: Int, arg2: Int, arg3: Int) { // TODO Auto-generated method stub
    }

    fun deleteAll() {
        surfRecordViewModel.deleteAll()
        currentIndex = 0
        isReg = true
        initStatus()
    }

    fun deleteSingle() {
        dataList?.get(currentIndex)?.date?.let { id ->
            surfRecordViewModel.delete(id)
            if (currentIndex > 0) {
                currentIndex--
            }
        }
        // The LiveData observer will handle calling updateStatus() or initStatus()
    }
}