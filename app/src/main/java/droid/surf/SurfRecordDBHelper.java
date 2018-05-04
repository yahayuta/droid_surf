package droid.surf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * データベース接続
 * @author yasupong
 */
public class SurfRecordDBHelper extends SQLiteOpenHelper {

	public static String DB_NAME = "SurfRecord";
	public static int DB_VERSON = 1;
	public static String DB_TABLE_SURFREC = "SurfRecord";
	
	public SurfRecordDBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSON);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL( "create table if not exists " + DB_TABLE_SURFREC + 
						"(date text primary key," +
						"ymd text not null," +
						"startTime text ," +
						"time text ," +
						"pointName text ," +
						"weather text ," +
						"wind text ," +
						"size text ," +
						"cloud text ," +
						"boardType text ," +
						"takeOff text ," +
						"comment text" +
						")" );
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL( "drop table if exists " + DB_TABLE_SURFREC );
		onCreate(arg0);
	}
}
