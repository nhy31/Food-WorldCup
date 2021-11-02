package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FoodDBHelper extends SQLiteOpenHelper {
    final static String TAG = "FoodDBHelper";

    final static String DB_NAME = "foods.db";
    public final static String TABLE_NAME = "food_table";

    public final static String COL_ID = "_id";
    public final static String COL_FOODNAME = "foodName";
    public final static String COL_IMG = "img";

    public FoodDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_FOODNAME + " TEXT, " + COL_IMG +  " int) ";
        Log.d(TAG, sql);
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, '김밥', " + R.mipmap.f1 + ")" );
        db.execSQL("insert into " + TABLE_NAME + " values (null, '햄버거', " + R.mipmap.f2 + ")" );
        db.execSQL("insert into " + TABLE_NAME + " values (null, '마라탕', " + R.mipmap.f3 + ")" );
        db.execSQL("insert into " + TABLE_NAME + " values (null, '떡볶이', " + R.mipmap.f4 + ")" );
        db.execSQL("insert into " + TABLE_NAME + " values (null, '돈까스', " + R.mipmap.f5 + ")" );
        db.execSQL("insert into " + TABLE_NAME + " values (null, '닭갈비', " + R.mipmap.f6 + ")" );
        db.execSQL("insert into " + TABLE_NAME + " values (null, '곱창', " + R.mipmap.f7 + ")" );
        db.execSQL("insert into " + TABLE_NAME + " values (null, '우동', " + R.mipmap.f8 + ")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}


