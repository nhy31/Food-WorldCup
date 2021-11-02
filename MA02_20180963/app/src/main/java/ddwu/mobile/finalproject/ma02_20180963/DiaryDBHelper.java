package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DiaryDBHelper extends SQLiteOpenHelper {
    final static String TAG = "DiaryDBHelper";

    final static String DB_NAME = "diary.db";
    public final static String TABLE_NAME = "diary_table";

    public final static String COL_ID = "_id";
    public final static String COL_DATE = "date";
    public final static String COL_FOOD = "food";
    public final static String COL_RES = "res";
    public final static String COL_IMG = "img";
    public final static String COL_MEMO = "memo";

    public DiaryDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_DATE + " TEXT, " + COL_FOOD + " TEXT, " + COL_RES + " TEXT, " +
                COL_MEMO + " TEXT, " + COL_IMG +  " int) ";
        Log.d(TAG, sql);
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME +
                " values (null, '10월 31일', '떡볶이', '죠스떡볶이', '동생이랑 먹음. 맛있었다', "
                + R.mipmap.f4 + ")" );
        db.execSQL("insert into " + TABLE_NAME +
                " values (null, '11월 11일', '마라탕', '라화쿵부', '다음에는 마라샹궈 먹어야지', "
                + R.mipmap.f3 + ")" );
        db.execSQL("insert into " + TABLE_NAME +
                " values (null, '12월 23일', '김밥', '사보르김밥', '드디어 종강', "
                + R.mipmap.f1 + ")" );
        db.execSQL("insert into " + TABLE_NAME +
                " values (null, '12월 25일', '곱창', '홍곱창', '크리스마스다. 올해도 끝.', "
                + R.mipmap.f7 + ")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}