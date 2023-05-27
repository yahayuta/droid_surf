package droid.surf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 波乗り記録ログリスト
 * @author yasupong
 */
public class SurfRecordLogListActivity extends Activity implements OnItemClickListener {
	
	/** ログ記録一覧 */
	private List<SurfRecordEntity> resultList = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        
        // リストビューを構築する
        makeRecordLogListView();
    }
    
	/**
	 * リストビューを構築する
	 */
	private void makeRecordLogListView() {
		
        List<String> viewList = new ArrayList<String>();
        resultList = SurfRecordrUtil.getAllRecord(this);
        
        if (resultList == null || resultList.size() == 0) {
        	viewList.add("NO DATA");
        }
        else {      	
        	for (Iterator<SurfRecordEntity> iterator = resultList.iterator(); iterator.hasNext();) {
				SurfRecordEntity surfRecordEntity = (SurfRecordEntity) iterator.next();
				String text = "";

				String year = surfRecordEntity.getYmd().substring(0, 4);
				String mon = surfRecordEntity.getYmd().substring(4, 6);
				String day = surfRecordEntity.getYmd().substring(6, 8);
				int monValue = Integer.parseInt(mon);
				monValue = monValue + 1;
				
				text = text + getString(R.string.log_date) + year + "/" + monValue + "/" + day + "\n";
				
				String h = surfRecordEntity.getStartTime().substring(0, 2);
				String m = surfRecordEntity.getStartTime().substring(2, 4);
				
				text = text + getString(R.string.log_time) + h + ":" + m + "\n";
				
				text = text + getString(R.string.log_hours) + surfRecordEntity.getTime() + "\n";
				text = text + getString(R.string.log_point) + surfRecordEntity.getPointName() + "\n";
				text = text + getString(R.string.log_weather) + surfRecordEntity.getWeather() + "\n";
				text = text + getString(R.string.log_wind) + surfRecordEntity.getWind() + "\n";
				text = text + getString(R.string.log_size) +surfRecordEntity.getSize() + "\n";
				text = text + getString(R.string.log_crowd) + surfRecordEntity.getCloud() + "\n";
				text = text + getString(R.string.log_board) + surfRecordEntity.getBoardType() + "\n";
				text = text + getString(R.string.log_takeoff) + surfRecordEntity.getTakeOff() + "\n";
				text = text + getString(R.string.log_comment) + surfRecordEntity.getComment();
				
	        	viewList.add(text);
			}
        }
        
        // 記録ログリスト表示リストを画面に表示
        ListView lv = new ListView(this);
        @SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, viewList.toArray(new String[0]));
        lv.setAdapter(adapter);
        
        LinearLayout layout = (LinearLayout)findViewById(R.id.statLayout);
        layout.removeAllViews();
        
        layout.addView(lv);
        
        // リスナー登録
        lv.setOnItemClickListener(this);
	}
	
	
	/* (non-Javadoc)
	 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		if (resultList == null || resultList.size() == 0) {
			return;
		}
		
		String msg = null;
		
		SurfRecordEntity surfRecordEntity = resultList.get(arg2);
        
		String year = surfRecordEntity.getYmd().substring(0, 4);
		String mon = surfRecordEntity.getYmd().substring(4, 6);
		String day = surfRecordEntity.getYmd().substring(6, 8);
		int monValue = Integer.parseInt(mon);
		monValue = monValue + 1;
		
		msg = getString(R.string.log_date) + year + "/" + monValue + "/" + day + " ";
		
		String h = surfRecordEntity.getStartTime().substring(0, 2);
		String m = surfRecordEntity.getStartTime().substring(2, 4);
		
		msg = msg + getString(R.string.log_time) +  h + ":" + m + " ";
		msg = msg + getString(R.string.log_hours) +  surfRecordEntity.getTime() + " ";
		msg = msg + getString(R.string.log_point) +  surfRecordEntity.getPointName() + " ";
		msg = msg + getString(R.string.log_wind) +  surfRecordEntity.getWind() + " ";
		msg = msg + getString(R.string.log_size) +  surfRecordEntity.getSize() + " ";
		msg = msg + getString(R.string.log_crowd) +  surfRecordEntity.getCloud() + " ";
		msg = msg + getString(R.string.log_takeoff) +  surfRecordEntity.getTakeOff() + " ";
		msg = msg + getString(R.string.log_hash);
		
        // 外部アプリへ記録を送信
        Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TITLE, getString(R.string.app_name));
		intent.putExtra(Intent.EXTRA_TEXT, msg); 
		startActivity(Intent.createChooser(intent, getString(R.string.log_title)));
	}
}