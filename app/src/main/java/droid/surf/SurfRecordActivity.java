package droid.surf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * 波乗り記録ＡＰＰ
 * @author yasupong
 *
 */
public class SurfRecordActivity extends Activity implements OnClickListener,  OnDateChangedListener, OnTimeChangedListener {
	
	/** メニューアイテムID0 */
	private final static int MENU_ITEM0 = 0;
	/** メニューアイテムID1 */
	private final static int MENU_ITEM1 = 1;
	/** メニューアイテムID2 */
	private final static int MENU_ITEM2 = 2;
	/** メニューアイテムID3 */
	private final static int MENU_ITEM3 = 3;
	/** メニューアイテムID4 */
	private final static int MENU_ITEM4 = 4;
	/** メニューアイテムID5 */
	private final static int MENU_ITEM5 = 5;
	/** メニューアイテムID6 */
	private final static int MENU_ITEM6 = 6;
	
    /** 天候表示用 */
	private List<String> WEATHER_VALUE_LIST = new ArrayList<String>();
	private Map<String, String> WEATHER_VALUE_MAP = new HashMap<String, String>();

    /** 風向き表示用配列 */
	private List<String> WIND_VALUE_LIST = new ArrayList<String>();
	private Map<String, String> WIND_VALUE_MAP = new HashMap<String, String>();
	
    /** サイズ表示用配列 */
	private List<String> SIZE_VALUE_LIST = new ArrayList<String>();
	private Map<String, String> SIZE_VALUE_MAP = new HashMap<String, String>();
	
    /** 混雑度表示用配列 */
	private List<String> CROWD_VALUE_LIST = new ArrayList<String>();
	private Map<String, String> CROWD_VALUE_MAP = new HashMap<String, String>();
	
    /** 板種類表示用配列 */
	private List<String> TYPE_VALUE_LIST = new ArrayList<String>();
	private Map<String, String> TYPE_VALUE_MAP = new HashMap<String, String>();
	
	/** メンバー変数：新規登録モードであるか */
	private boolean isReg = true;
	/** メンバー変数：データリスト */
	private List<SurfRecordEntity> dataList = null;
	/** メンバー変数：表示中のインデックス */
	private int currentIndex = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // 初期化
        init();
        
        TimePicker tpStart = (TimePicker)findViewById(R.id.timePickerStart);
        tpStart.setIs24HourView(true);
        
        // プルダウンの生成
        refreshSpinner();
        
        // ボタンイベントリスナー設定
        Button btnSave = (Button) findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(this);
        Button btnFwd = (Button)findViewById(R.id.buttonFwd);
        btnFwd.setOnClickListener(this);
        Button btnBwd = (Button)findViewById(R.id.buttonRev);
        btnBwd.setOnClickListener(this);
        Button btnDel = (Button)findViewById(R.id.buttonDel);
        btnDel.setOnClickListener(this);
        
        // 状態初期化
        initStatus();
        
        //AdView初期化
        AdView adView = (AdView)this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder().build());
    }
    
    // 初期化
    private void init(){
    	// 天候
    	WEATHER_VALUE_LIST.add(getString(R.string.weather_fine));
    	WEATHER_VALUE_LIST.add(getString(R.string.weather_cloud));
    	WEATHER_VALUE_LIST.add(getString(R.string.weather_rain));
    	WEATHER_VALUE_LIST.add(getString(R.string.weather_snow));
    	
		for (int i = 0; i < WEATHER_VALUE_LIST.size(); i++) {
			String array_element = WEATHER_VALUE_LIST.get(i);
			WEATHER_VALUE_MAP.put(array_element, String.valueOf(i));
		}
		
		// 風
		WIND_VALUE_LIST.add(getString(R.string.wind_none));
		WIND_VALUE_LIST.add(getString(R.string.wind_strong_off));
		WIND_VALUE_LIST.add(getString(R.string.wind_off));
		WIND_VALUE_LIST.add(getString(R.string.wind_weak_off));
		WIND_VALUE_LIST.add(getString(R.string.wind_strong_on));
		WIND_VALUE_LIST.add(getString(R.string.wind_on));
		WIND_VALUE_LIST.add(getString(R.string.wind_weak_on));
		WIND_VALUE_LIST.add(getString(R.string.wind_side_off));
		WIND_VALUE_LIST.add(getString(R.string.wind_side_on));
		
		for (int i = 0; i < WIND_VALUE_LIST.size(); i++) {
			String array_element = WIND_VALUE_LIST.get(i);
			WIND_VALUE_MAP.put(array_element, String.valueOf(i));
		}
		
		//サイズ
		SIZE_VALUE_LIST.add(getString(R.string.size_flat));
		SIZE_VALUE_LIST.add(getString(R.string.size_ankle));
		SIZE_VALUE_LIST.add(getString(R.string.size_shin));
		SIZE_VALUE_LIST.add(getString(R.string.size_knee));
		SIZE_VALUE_LIST.add(getString(R.string.size_thigh));
		SIZE_VALUE_LIST.add(getString(R.string.size_waist));
		SIZE_VALUE_LIST.add(getString(R.string.size_belly));
		SIZE_VALUE_LIST.add(getString(R.string.size_chest));
		SIZE_VALUE_LIST.add(getString(R.string.size_shoulder));
		SIZE_VALUE_LIST.add(getString(R.string.size_head));
		SIZE_VALUE_LIST.add(getString(R.string.size_over_h));
		SIZE_VALUE_LIST.add(getString(R.string.size_double));
		SIZE_VALUE_LIST.add(getString(R.string.size_triple));
		SIZE_VALUE_LIST.add(getString(R.string.size_giant));
		
		for (int i = 0; i < SIZE_VALUE_LIST.size(); i++) {
			String array_element = SIZE_VALUE_LIST.get(i);
			SIZE_VALUE_MAP.put(array_element, String.valueOf(i));
		}
		
		// 混雑度
		CROWD_VALUE_LIST.add(getString(R.string.crowd_noone));
		CROWD_VALUE_LIST.add(getString(R.string.crowd_low));
		CROWD_VALUE_LIST.add(getString(R.string.crowd_normal));
		CROWD_VALUE_LIST.add(getString(R.string.crowd_high));
		CROWD_VALUE_LIST.add(getString(R.string.crowd_heavy));
		
		for (int i = 0; i < CROWD_VALUE_LIST.size(); i++) {
			String array_element = CROWD_VALUE_LIST.get(i);
			CROWD_VALUE_MAP.put(array_element, String.valueOf(i));
		}
		
		// 板種類
		TYPE_VALUE_LIST.add(getString(R.string.board_short));
		TYPE_VALUE_LIST.add(getString(R.string.board_fun));
		TYPE_VALUE_LIST.add(getString(R.string.board_long));
		TYPE_VALUE_LIST.add(getString(R.string.board_sup));
		TYPE_VALUE_LIST.add(getString(R.string.board_gun));
		TYPE_VALUE_LIST.add(getString(R.string.board_bb));
		
		for (int i = 0; i < TYPE_VALUE_LIST.size(); i++) {
			String array_element = TYPE_VALUE_LIST.get(i);
			TYPE_VALUE_MAP.put(array_element, String.valueOf(i));
		}
    }
    
	/**
	 * プルダウンの生成
	 */
	private void refreshSpinner() {
		
		// 天候
        ArrayAdapter<String> adapterWeather = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapterWeather.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (int i = 0; i < WEATHER_VALUE_LIST.size(); i++) {
        	adapterWeather.add(WEATHER_VALUE_LIST.get(i));
		}

        Spinner spinnerWeather = (Spinner)findViewById(R.id.spinnerWeather);
        spinnerWeather.setAdapter(adapterWeather);
        
		// 風向き
        ArrayAdapter<String> adapterWind = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapterWind.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (int i = 0; i < WIND_VALUE_LIST.size(); i++) {
        	adapterWind.add(WIND_VALUE_LIST.get(i));
		}

        Spinner spinnerWind = (Spinner)findViewById(R.id.spinnerWind);
        spinnerWind.setAdapter(adapterWind);
        
		// サイズ
        ArrayAdapter<String> adapterSize = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapterSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (int i = 0; i < SIZE_VALUE_LIST.size(); i++) {
        	adapterSize.add(SIZE_VALUE_LIST.get(i));
		}

        Spinner spinnerSize = (Spinner)findViewById(R.id.spinnerSize);
        spinnerSize.setAdapter(adapterSize);
        
		// 混雑度
        ArrayAdapter<String> adapterCloud = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapterCloud.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (int i = 0; i < CROWD_VALUE_LIST.size(); i++) {
        	adapterCloud.add(CROWD_VALUE_LIST.get(i));
		}

        Spinner spinnerCloud = (Spinner)findViewById(R.id.spinnerCloud);
        spinnerCloud.setAdapter(adapterCloud);
        
		// 板種類
        ArrayAdapter<String> adapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (int i = 0; i < TYPE_VALUE_LIST.size(); i++) {
        	adapterType.add(TYPE_VALUE_LIST.get(i));
		}

        Spinner spinnerType = (Spinner)findViewById(R.id.spinnerBoard);
        spinnerType.setAdapter(adapterType);
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View arg0) {
        Button btnSave = (Button)findViewById(R.id.buttonSave);
        Button btnFwd = (Button)findViewById(R.id.buttonFwd);
        Button btnBwd = (Button)findViewById(R.id.buttonRev);
        Button btnDel = (Button)findViewById(R.id.buttonDel);
        if (arg0 == btnSave) {
        	execBtnSave();
        }
        if (arg0 == btnFwd) {
        	currentIndex++;
        	updateStatus();
        }
        if (arg0 == btnBwd) {
        	currentIndex--;
        	updateStatus();
        }
        // 削除
        if (arg0 == btnDel) {
        	if (!isReg) {
        		delete();
        	}
        }
	}
	
	/**
	 * 状態初期化
	 */
	private void initStatus() {
		
		// 画面部品取得
		EditText textTime = (EditText)findViewById(R.id.editHours);
		EditText textPoint = (EditText)findViewById(R.id.editTextPoint);
		Spinner spinnerWeather = (Spinner)findViewById(R.id.spinnerWeather);
		Spinner spinnerWind = (Spinner)findViewById(R.id.spinnerWind);
		Spinner spinnerSize = (Spinner)findViewById(R.id.spinnerSize);
		Spinner spinnerCloud = (Spinner)findViewById(R.id.spinnerCloud);
		Spinner spinnerBoard = (Spinner)findViewById(R.id.spinnerBoard);
		EditText textTakeOff = (EditText)findViewById(R.id.editTextTakeOff);
		EditText textComment = (EditText)findViewById(R.id.editComment);
		
		Button btnFwd = (Button)findViewById(R.id.buttonFwd);
        Button btnRev = (Button)findViewById(R.id.buttonRev);
        Button btnDel = (Button)findViewById(R.id.buttonDel);
        
		// 新規登録モード
		if (isReg) {
			// 全表示クリア
			textTime.setText("");
			textPoint.setText("");
			spinnerWeather.setSelection(0);
			spinnerWind.setSelection(0);
			spinnerSize.setSelection(0);
			spinnerCloud.setSelection(0);
			spinnerBoard.setSelection(0);
			textTakeOff.setText("");
			textComment.setText("");
			
            btnFwd.setVisibility(View.GONE);
        	btnRev.setVisibility(View.GONE);
        	btnDel.setVisibility(View.GONE);
		}
		// 更新モード
		else {
			// 全データ取得
			dataList = SurfRecordrUtil.getAllRecord(this);
			if (dataList == null || dataList.size() == 0) {
				isReg = true;
				return;
			}
        	
        	setData();
			
			if (dataList.size() > 1) {
	            btnFwd.setVisibility(View.VISIBLE);
			}
			
        	btnDel.setVisibility(View.VISIBLE);
		}
	}
	
	/**
	 * データ状態更新
	 */
	private void updateStatus() {
		
		// 画面部品取得
		Button btnFwd = (Button)findViewById(R.id.buttonFwd);
        Button btnRev = (Button)findViewById(R.id.buttonRev);
        Button btnDel = (Button)findViewById(R.id.buttonDel);
        
        if (dataList.size() > 0) {
        	btnDel.setVisibility(View.VISIBLE);
        }
        else {
        	btnDel.setVisibility(View.GONE);
        }
        
        if ((currentIndex + 1) >= dataList.size()) {
            btnFwd.setVisibility(View.GONE);
        }
        else {
            btnFwd.setVisibility(View.VISIBLE);
        }

        if (currentIndex == 0) {
        	btnRev.setVisibility(View.GONE);
        }
        else {
        	btnRev.setVisibility(View.VISIBLE);
        }
        
        setData();
	}
	
	/**
	 * 画面にデータ表示
	 */
	private void setData() {
		DatePicker dpYmd = (DatePicker)findViewById(R.id.datePickerDay);
		TimePicker tpStart = (TimePicker)findViewById(R.id.timePickerStart);
		EditText textTime = (EditText)findViewById(R.id.editHours);
		EditText textPoint = (EditText)findViewById(R.id.editTextPoint);
		Spinner spinnerWeather = (Spinner)findViewById(R.id.spinnerWeather);
		Spinner spinnerWind = (Spinner)findViewById(R.id.spinnerWind);
		Spinner spinnerSize = (Spinner)findViewById(R.id.spinnerSize);
		Spinner spinnerCloud = (Spinner)findViewById(R.id.spinnerCloud);
		Spinner spinnerBoard = (Spinner)findViewById(R.id.spinnerBoard);
		EditText textTakeOff = (EditText)findViewById(R.id.editTextTakeOff);
		EditText textComment = (EditText)findViewById(R.id.editComment);
		
		String ymd = ((SurfRecordEntity)dataList.get(currentIndex)).getYmd();
		int year = Integer.parseInt(ymd.substring(0, 4));
		int mon = Integer.parseInt(ymd.substring(4, 6));
		int day = Integer.parseInt(ymd.substring(6, 8));
		
		dpYmd.init(year, mon, day, this);
		
		String time = ((SurfRecordEntity)dataList.get(currentIndex)).getStartTime();
		
		int h = Integer.parseInt(time.substring(0, 2));
		int m = Integer.parseInt(time.substring(2, 4));
		tpStart.setCurrentHour(h);
		tpStart.setCurrentMinute(m);
		tpStart.setOnTimeChangedListener(this);
        
		textTime.setText(((SurfRecordEntity)dataList.get(currentIndex)).getTime());
		textPoint.setText(((SurfRecordEntity)dataList.get(currentIndex)).getPointName());
		spinnerWeather.setSelection(Integer.valueOf((String)WEATHER_VALUE_MAP.get(((SurfRecordEntity)dataList.get(currentIndex)).getWeather())));
		spinnerWind.setSelection(Integer.valueOf((String)WIND_VALUE_MAP.get(((SurfRecordEntity)dataList.get(currentIndex)).getWind())));
		spinnerSize.setSelection(Integer.valueOf((String)SIZE_VALUE_MAP.get(((SurfRecordEntity)dataList.get(currentIndex)).getSize())));
		spinnerCloud.setSelection(Integer.valueOf((String)CROWD_VALUE_MAP.get(((SurfRecordEntity)dataList.get(currentIndex)).getCloud())));
		spinnerBoard.setSelection(Integer.valueOf((String)TYPE_VALUE_MAP.get(((SurfRecordEntity)dataList.get(currentIndex)).getBoardType())));
		textTakeOff.setText(((SurfRecordEntity)dataList.get(currentIndex)).getTakeOff());
		textComment.setText(((SurfRecordEntity)dataList.get(currentIndex)).getComment());
	}
	
	/**
	 * SAVEボタン処理
	 */
	private void execBtnSave() {
		// DB更新
		SurfRecordDBHelper dbHelper = new SurfRecordDBHelper(getBaseContext());
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		try {
			ContentValues values = new ContentValues();
			
			// 日時
			if (isReg) {
				values.put("date", System.currentTimeMillis());
			}
			else {
				values.put("date", ((SurfRecordEntity)dataList.get(currentIndex)).getDate());	
			}
			
			// 画面部品取得
			DatePicker dpYmd = (DatePicker)findViewById(R.id.datePickerDay);
			TimePicker tpStart = (TimePicker)findViewById(R.id.timePickerStart);
			EditText textTime = (EditText)findViewById(R.id.editHours);
			EditText textPoint = (EditText)findViewById(R.id.editTextPoint);
			Spinner spinnerWeather = (Spinner)findViewById(R.id.spinnerWeather);
			Spinner spinnerWind = (Spinner)findViewById(R.id.spinnerWind);
			Spinner spinnerSize = (Spinner)findViewById(R.id.spinnerSize);
			Spinner spinnerCloud = (Spinner)findViewById(R.id.spinnerCloud);
			Spinner spinnerBoard = (Spinner)findViewById(R.id.spinnerBoard);
			EditText textTakeOff = (EditText)findViewById(R.id.editTextTakeOff);
			EditText textComment = (EditText)findViewById(R.id.editComment);
			
			// 波乗り日
			int year = dpYmd.getYear();
			int mon = dpYmd.getMonth();
			int day = dpYmd.getDayOfMonth();
			String ymd = String.valueOf(year);
			if (mon < 10) {
				ymd = ymd + "0" + mon;
			}
			else {
				ymd = ymd + mon;
			}
			
			if (day < 10) {
				ymd = ymd + "0" + day;
			}
			else {
				ymd = ymd + day;
			}
			
			values.put("ymd", ymd);
			
			// 波乗り開始時刻
			int h = tpStart.getCurrentHour();
			int m = tpStart.getCurrentMinute();
			
			String hm = "";
			if (h < 10) {
				hm = hm + "0" + h;
			}
			else {
				hm = hm + h;
			}
			
			if (m < 10) {
				hm = hm + "0" + m;
			}
			else {
				hm = hm + m;
			}
			
			values.put("startTime", hm);
			
			// 波乗り時間
			// NULLチェック
			if (isNull(textTime.getText().toString(),getString(R.string.disp_time))) return;
			// 数値チェック
			if (!isInteger(textTime.getText().toString(),getString(R.string.disp_time))) return;
			values.put("time", textTime.getText().toString());
			
			// 波乗りポイント名称			
			values.put("pointName", textPoint.getText().toString());
			
			// 天候			
			values.put("weather", (String)spinnerWeather.getSelectedItem());
			
			// 風向き			
			values.put("wind", (String)spinnerWind.getSelectedItem());
			
			// サイズ			
			values.put("size", (String)spinnerSize.getSelectedItem());
			
			// 混雑度		
			values.put("cloud", (String)spinnerCloud.getSelectedItem());
			
			// 板の種類		
			values.put("boardType", (String)spinnerBoard.getSelectedItem());
			
			// テイクオフ回数
			// NULLチェック
			if (isNull(textTime.getText().toString(),getString(R.string.disp_takeoff))) return;
			// 数値チェック
			if (!isInteger(textTakeOff.getText().toString(),getString(R.string.disp_takeoff))) return;
			values.put("takeOff", textTakeOff.getText().toString());
			
			// コメント		
			values.put("comment", textComment.getText().toString());
			
			// データ挿入
			if (isReg) {
				db.insert(SurfRecordDBHelper.DB_TABLE_SURFREC, null, values);
				
				// 表示くクリア
				textTime.setText("");
				textPoint.setText("");
				spinnerWeather.setSelection(0);
				spinnerWind.setSelection(0);
				spinnerSize.setSelection(0);
				spinnerCloud.setSelection(0);
				spinnerBoard.setSelection(0);
				textTakeOff.setText("");
				textComment.setText("");
			}
			// データ更新
			else {
				db.update(SurfRecordDBHelper.DB_TABLE_SURFREC, values, "date=" + ((SurfRecordEntity)dataList.get(currentIndex)).getDate(), null);
			}
		}
		finally {
			db.close();
		}

		// 正常保存
		AlertDialog.Builder dlg = new AlertDialog.Builder(this);
		dlg.setMessage(getString(R.string.msg_saved));
		dlg.setPositiveButton("OK", null);
		dlg.show();
		
		initStatus();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		// 波乗り記録詳細メニュー追加
		MenuItem actionItem0 = menu.add(0, MENU_ITEM0, 0, getString(R.string.menu_detail));
		actionItem0.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// 波乗り記録チャートメニュー追加
		MenuItem actionItem1 = menu.add(0, MENU_ITEM1, 0, getString(R.string.menu_chart));
		actionItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// 波乗り記録新規登録メニュー追加
		MenuItem actionItem2 = menu.add(0, MENU_ITEM2, 0, getString(R.string.menu_add));
		actionItem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// 波乗り記録編集メニュー追加
		MenuItem actionItem3 = menu.add(0, MENU_ITEM3, 0, getString(R.string.menu_edit));
		actionItem3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// 波乗り記録ログ一覧メニュー追加
		MenuItem actionItem4 = menu.add(0, MENU_ITEM4, 0, getString(R.string.menu_loglist));
		actionItem4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// 波乗り記録エクスポートメニュー追加
		MenuItem actionItem5 = menu.add(0, MENU_ITEM5, 0, getString(R.string.menu_export));
		actionItem5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// 波乗り記録リセットメニュー追加
		MenuItem actionItem6 = menu.add(0, MENU_ITEM6, 0, getString(R.string.menu_reset));
		actionItem6.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case MENU_ITEM0:
				// 波乗り記録詳細メニュー
		        Intent intent = new Intent(SurfRecordActivity.this, SurfRecordDetailActivity.class);
		        startActivity(intent);
				return true;
			case MENU_ITEM1:
				// 波乗り記録チャートメニュー
		        Intent intent2 = new Intent(SurfRecordActivity.this, SurfRecordChartActivity.class);
		        startActivity(intent2);
				return true;
			case MENU_ITEM2:
				// 波乗り記録新規登録メニュー
				isReg = true;
				initStatus();
				return true;
			case MENU_ITEM3:
				// 波乗り記録編集メニュー
				isReg = false;
				initStatus();
				return true;
			case MENU_ITEM4:
				// 記録ログ一覧トメニュー
		        Intent intent3 = new Intent(SurfRecordActivity.this, SurfRecordLogListActivity.class);
		        startActivity(intent3);
				return true;
			case MENU_ITEM5:
				// 波乗り記録エクスポートメニュー
				exportRecordLog();
				return true;
			case MENU_ITEM6:
				// 波乗り記録リセットメニュー
				AlertDialog.Builder dlg = new AlertDialog.Builder(this);
				dlg.setMessage(getString(R.string.msg_all_del_con));
        		DialogInterface.OnClickListener listnerAllDel = new DialogInterface.OnClickListener(){
        			public void onClick(DialogInterface dialog, int which) {
        				deleteAll();
        			}
        		};
				dlg.setPositiveButton("Yes", listnerAllDel);
				dlg.setNegativeButton("No", listnerAllDel);
				dlg.show();
				return true;

		}
		return true;
	}
	
	/**
	 * 波乗記録記録保存
	 */
	private void exportRecordLog() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		
		String text = "";
        List<SurfRecordEntity> resultList = SurfRecordrUtil.getAllRecord(this);
        
        // ログリスト作成
		for (Iterator<SurfRecordEntity> iterator = resultList.iterator(); iterator.hasNext();) {
			SurfRecordEntity data = (SurfRecordEntity) iterator.next();
			
			String year = data.getYmd().substring(0, 4);
			String mon = data.getYmd().substring(4, 6);
			String day = data.getYmd().substring(6, 8);
			int monValue = Integer.parseInt(mon);
			monValue = monValue + 1;
			text = text + year + "/" + monValue + "/" + day + ",";
			
			String h = data.getStartTime().substring(0, 2);
			String m = data.getStartTime().substring(2, 4);
			text = text + h + ":" + m  + ",";
			
			text = text + data.getTime() + ",";
			text = text + data.getPointName() + ",";
			text = text + data.getWeather() + ",";
			text = text + data.getWind() + ",";
			text = text + data.getSize() + ",";
			text = text + data.getCloud() + ",";
			text = text + data.getBoardType() + ",";
			text = text + data.getTakeOff() + "\n";
		}
		
		intent.putExtra(Intent.EXTRA_TEXT, text);  
		startActivity(Intent.createChooser(intent, getString(R.string.menu_exp_other)));
	}
	
	/**
	 * データ削除
	 */
	private void delete() {
		// 確認ダイアログ表示
		AlertDialog.Builder dlg = new AlertDialog.Builder(this);
		dlg.setMessage(getString(R.string.msg_del_con));
		DialogInterface.OnClickListener listnerDel = new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int which) {
				deleteSingle();
			}
		};
		dlg.setPositiveButton("Yes", listnerDel);
		dlg.setNegativeButton("No", listnerDel);
		dlg.show();
	}
	
	/**
	 * 数値チェック
	 * @param num
	 * @param data
	 * @return
	 */
	private boolean isInteger(String num, String data) {
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setMessage(data + getString(R.string.msg_need_number));
			dlg.setPositiveButton("OK", null);
			dlg.show();
			return false;
		}
	}	

	/**
	 * NULLチェック
	 * @param str
	 * @param data
	 * @return
	 */
	private boolean isNull(String str, String data) {
		if (str == null || str.length() == 0) {
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setMessage(data + getString(R.string.msg_no_null));
			dlg.setPositiveButton("OK", null);
			dlg.show();
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see android.widget.TimePicker.OnTimeChangedListener#onTimeChanged(android.widget.TimePicker, int, int)
	 */
	@Override
	public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see android.widget.DatePicker.OnDateChangedListener#onDateChanged(android.widget.DatePicker, int, int, int)
	 */
	@Override
	public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 全データ削除
	 */
	public void deleteAll() {
		SurfRecordDBHelper dbHelper = new SurfRecordDBHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		try {
			db.delete(SurfRecordDBHelper.DB_TABLE_SURFREC, null, null);
			currentIndex = 0;
			isReg = true;
			// 初期化
			initStatus();
		}
		finally {
			db.close();
			dbHelper.close();
		}
	}
	
	/**
	 * 指定したレコードを削除する
	 */
	public void deleteSingle() {
		SurfRecordDBHelper dbHelper = new SurfRecordDBHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		try {
			String id = ((SurfRecordEntity)dataList.get(currentIndex)).getDate();
			db.delete(SurfRecordDBHelper.DB_TABLE_SURFREC, "date=" + id, null);
			
			if (currentIndex > 0) {
				currentIndex--;
			}

			// 全データ取得
			dataList = SurfRecordrUtil.getAllRecord(this);
			
			if (dataList == null || dataList.isEmpty()) {
				isReg = true;
				initStatus();
			}
			else {
		        // 状態更新
		        updateStatus();
			}
		}
		finally {
			db.close();
			dbHelper.close();
		}
	}
}