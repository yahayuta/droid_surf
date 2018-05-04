package droid.surf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * 波乗り記録詳細
 * @author yasupong
 */
public class SurfRecordDetailActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        
        // リストビューを構築する
        makeRecordStatListView();
    }
    
	/**
	 * リストビューを構築する
	 */
	private void makeRecordStatListView() {
		
        List<String> viewList = new ArrayList<String>();
        List<SurfRecordEntity> resultList = SurfRecordrUtil.getAllRecord(this);
        
        if (resultList == null || resultList.size() == 0) {
        	viewList.add("NO DATA");
        }
        else {
        	
        	double hours = 0;
        	int takeOff = 0;
        	
        	for (Iterator<SurfRecordEntity> iterator = resultList.iterator(); iterator.hasNext();) {
				SurfRecordEntity surfRecordEntity = (SurfRecordEntity) iterator.next();
				hours = hours + Double.parseDouble(surfRecordEntity.getTime());
				takeOff = takeOff + Integer.parseInt(surfRecordEntity.getTakeOff());
			}
        	
        	viewList.add(getString(R.string.detail_num_surf) + resultList.size());
        	viewList.add(getString(R.string.detail_time) + hours);
        	viewList.add(getString(R.string.detail_takeoff) + takeOff);
        	viewList.add(getString(R.string.detail_ave_time) + SurfRecordrUtil.subStr(String.valueOf(hours / resultList.size())));
        	viewList.add(getString(R.string.detail_ave_takeoff) + (takeOff / resultList.size()));
        	
        	// 何分おきにテイクオフできているか
        	double takeOffRate = ( hours * 60 ) / takeOff;
        	viewList.add(getString(R.string.detail_takeoff_rate) + SurfRecordrUtil.subStr(String.valueOf(takeOffRate)) + getString(R.string.detail_takeoff_rate_msg));
        }
        
        // 統計表示リストを画面に表示
        ListView lv = new ListView(this);
        @SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, viewList.toArray(new String[0]));
        lv.setAdapter(adapter);
        
        LinearLayout layout = (LinearLayout)findViewById(R.id.statLayout);
        layout.removeAllViews();
        
        addAdView(layout);
        
        layout.addView(lv);
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