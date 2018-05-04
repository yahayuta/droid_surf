package droid.surf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 共通部品
 * @author yasupong
 */
public class SurfRecordrUtil {
	
	/** 数値長さ */
	private final static int MAX_LENGTH = 6;
	
	/**
	 * 全データ取得
	 * @param cnt
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static List<SurfRecordEntity> getAllRecord(Context cnt) {
		
		SurfRecordDBHelper dbHelper = new SurfRecordDBHelper(cnt);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		Cursor cAll = db.query(SurfRecordDBHelper.DB_TABLE_SURFREC, new String[]{ "date","ymd","startTime","time","pointName","weather","wind","size","cloud","boardType","takeOff","comment" }, null, null, null, null, "ymd desc");

        List<SurfRecordEntity> resultList = new ArrayList<SurfRecordEntity>();
        
		@SuppressWarnings("unused")
		SimpleDateFormat sdfDB = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
        // リストに落とし込む
        while (cAll.moveToNext()){
        	SurfRecordEntity data = new SurfRecordEntity();
        	
        	data.setDate(cAll.getString(0));
        	data.setYmd(cAll.getString(1));
        	data.setStartTime(cAll.getString(2));
        	data.setTime(cAll.getString(3));
        	data.setPointName(cAll.getString(4));
          	data.setWeather(cAll.getString(5));
          	data.setWind(cAll.getString(6));
          	data.setSize(cAll.getString(7));
          	data.setCloud(cAll.getString(8));
          	data.setBoardType(cAll.getString(9));
          	data.setTakeOff(cAll.getString(10));
          	data.setComment(cAll.getString(11));
          	
        	resultList.add(data);
        }
        
        cAll.close();
        db.close();
        
        return resultList;
	}
	
	/**
	 * サブストリングする
	 * @param in
	 * @return
	 */
	public static String subStr(String in) {
		if (in.length() > MAX_LENGTH) {
			in = in.substring(0,MAX_LENGTH);
		}
		return in;
	}
}
