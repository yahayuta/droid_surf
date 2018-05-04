package droid.surf;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * FuelUsageAnalyzerChartActivity
 * @author yasupong
 */
public class SurfRecordChartActivity extends Activity {
	
	/** メニューアイテムID0 */
	private final int MENU_ITEM0 = 0;
	/** メニューアイテムID1 */
	private final int MENU_ITEM1 = 1;
	/** メニューアイテムID2 */
	private final int MENU_ITEM2 = 2;
	/** メニューアイテムID3 */
	private final int MENU_ITEM3 = 3;
	/** メニューアイテムID4 */
	private final int MENU_ITEM4 = 4;
	/** メニューアイテムID5 */
	private final int MENU_ITEM5 = 5;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        
        // デフォルト表示
        loadPointChart();
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		// ポイント
		MenuItem actionItem0 = menu.add(0, MENU_ITEM0, 0, getString(R.string.chart_menu_point));
		actionItem0.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// サイズ
		MenuItem actionItem1 = menu.add(0, MENU_ITEM1, 0, getString(R.string.chart_menu_size));
		actionItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// ポイント別時間
		MenuItem actionItem2 = menu.add(0, MENU_ITEM2, 0, getString(R.string.chart_menu_time_point));
		actionItem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// サイズ別テイクオフ数
		MenuItem actionItem3 = menu.add(0, MENU_ITEM3, 0, getString(R.string.chart_menu_to_size));
		actionItem3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// ポイント別テイクオフ数
		MenuItem actionItem4 = menu.add(0, MENU_ITEM4, 0, getString(R.string.chart_menu_to_point));
		actionItem4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		// 混雑度別テイクオフ数
		MenuItem actionItem5 = menu.add(0, MENU_ITEM5, 0, getString(R.string.chart_menu_to_crowd));
		actionItem5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case MENU_ITEM0:
				// ポイント
				loadPointChart();
				return true;
			case MENU_ITEM1:
				// サイズ
				loadSizeChart();
				return true;
			case MENU_ITEM2:
				// ポイント別時間
				loadTimeOfPointChart();
				return true;
			case MENU_ITEM3:
				// サイズ別テイクオフ数
				loadTakeOffBySizeChart();
				return true;
			case MENU_ITEM4:
				// ポイント別テイクオフ数
				loadTakeOffByPointChart();
				return true;
			case MENU_ITEM5:
				// 混雑度別テイクオフ数
				loadTakeOffByCloudChart();
				return true;
		}
		return true;
	}
	
	/**
	 * ポイントチャート
	 */
	private void loadPointChart() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.statLayout);
        layout.removeAllViews();
        
        addAdView(layout);
        
        // ビューの作成
        SurfRecordChartView cView = new SurfRecordChartView(this);
        // ログビリスト取得
        cView.setLogList(SurfRecordrUtil.getAllRecord(this));
        cView.setChart_name(getString(R.string.chart_menu_point));
        cView.setChart_x_label(getString(R.string.chart_lbl_point));
        cView.setChart_y_label(getString(R.string.chart_lbl_count));
        cView.setChart_plot(getString(R.string.chart_menu_point));
        cView.setChart_type(0);
        
        layout.addView(cView);
	}
	
	/**
	 * サイズチャート
	 */
	private void loadSizeChart() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.statLayout);
        layout.removeAllViews();
        
        addAdView(layout);
        
        // ビューの作成
        SurfRecordChartView cView = new SurfRecordChartView(this);
        // ログビリスト取得
        cView.setLogList(SurfRecordrUtil.getAllRecord(this));
        cView.setChart_name(getString(R.string.chart_menu_size));
        cView.setChart_x_label(getString(R.string.chart_lbl_size));
        cView.setChart_y_label(getString(R.string.chart_lbl_count));
        cView.setChart_plot(getString(R.string.chart_menu_size));
        cView.setChart_type(1);
        
        layout.addView(cView);
	}

	/**
	 * ポイント別時間
	 */
	private void loadTimeOfPointChart() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.statLayout);
        layout.removeAllViews();
        
        addAdView(layout);
        
        // ビューの作成
        SurfRecordChartView cView = new SurfRecordChartView(this);
        // ログビリスト取得
        cView.setLogList(SurfRecordrUtil.getAllRecord(this));
        cView.setChart_name(getString(R.string.chart_menu_time_point));
        cView.setChart_x_label(getString(R.string.chart_lbl_point));
        cView.setChart_y_label(getString(R.string.chart_lbl_hours));
        cView.setChart_plot(getString(R.string.chart_menu_time_point));
        cView.setChart_type(2);
        
        layout.addView(cView);
	}
	
	/**
	 * サイズ別テイクオフ数
	 */
	private void loadTakeOffBySizeChart() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.statLayout);
        layout.removeAllViews();
        
        addAdView(layout);
        
        // ビューの作成
        SurfRecordChartView cView = new SurfRecordChartView(this);
        // ログビリスト取得
        cView.setLogList(SurfRecordrUtil.getAllRecord(this));
        cView.setChart_name(getString(R.string.chart_menu_to_size));
        cView.setChart_x_label(getString(R.string.chart_lbl_size));
        cView.setChart_y_label(getString(R.string.chart_lbl_takeoffs));
        cView.setChart_plot(getString(R.string.chart_menu_to_size));
        cView.setChart_type(3);
        
        layout.addView(cView);
	}
	
	/**
	 * ポイント別テイクオフ数チャート
	 */
	private void loadTakeOffByPointChart() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.statLayout);
        layout.removeAllViews();
        
        addAdView(layout);
        
        // ビューの作成
        SurfRecordChartView cView = new SurfRecordChartView(this);
        // ログビリスト取得
        cView.setLogList(SurfRecordrUtil.getAllRecord(this));
        cView.setChart_name(getString(R.string.chart_menu_to_point));
        cView.setChart_x_label(getString(R.string.chart_lbl_point));
        cView.setChart_y_label(getString(R.string.chart_lbl_takeoffs));
        cView.setChart_plot(getString(R.string.chart_menu_to_point));
        cView.setChart_type(4);
        
        layout.addView(cView);
	}
	
	/**
	 * 混雑度別テイクオフ数チャート
	 */
	private void loadTakeOffByCloudChart() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.statLayout);
        layout.removeAllViews();
        
        addAdView(layout);
        
        // ビューの作成
        SurfRecordChartView cView = new SurfRecordChartView(this);
        // ログビリスト取得
        cView.setLogList(SurfRecordrUtil.getAllRecord(this));
        cView.setChart_name(getString(R.string.chart_menu_to_crowd));
        cView.setChart_x_label(getString(R.string.chart_lbl_crowd));
        cView.setChart_y_label(getString(R.string.chart_lbl_takeoffs));
        cView.setChart_plot(getString(R.string.chart_menu_to_crowd));
        cView.setChart_type(5);
        
        layout.addView(cView);
	}
	
	/**
	 * adMobビューを追加する
	 * @param layout
	 */
	private void addAdView(LinearLayout layout) { 
        AdView adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-4280826531916194/3987301506");
        adView.setAdSize(AdSize.SMART_BANNER);
        layout.addView(adView);
		adView.loadAd(new AdRequest.Builder().build());
	}
}