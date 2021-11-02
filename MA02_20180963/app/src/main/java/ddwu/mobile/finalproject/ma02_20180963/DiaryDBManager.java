package ddwu.mobile.finalproject.ma02_20180963;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DiaryDBManager {

    DiaryDBHelper dbHelper;
    Cursor cursor = null;

    public DiaryDBManager(Context context)
    { dbHelper = new DiaryDBHelper(context); }

    public ArrayList<Diary> getAllDiary() {
        ArrayList diaryList = new ArrayList();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_NAME, null, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
            String date = cursor.getString(cursor.getColumnIndex(dbHelper.COL_DATE));
            String food = cursor.getString(cursor.getColumnIndex(dbHelper.COL_FOOD));
            String res = cursor.getString(cursor.getColumnIndex(dbHelper.COL_RES));
            int img = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_IMG));
            String memo =  cursor.getString(cursor.getColumnIndex(dbHelper.COL_MEMO));

            diaryList.add ( new Diary(id, date, food, res, img, memo));
        }

        cursor.close();
        dbHelper.close();
        return diaryList;
    }

    public boolean addNewDiary(Diary newDiary) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put(dbHelper.COL_FOOD, newDiary.getFood());
        value.put(dbHelper.COL_IMG, newDiary.getImg());
        value.put(dbHelper.COL_DATE, newDiary.getDate());
        value.put(dbHelper.COL_RES, newDiary.getRes());
        value.put(dbHelper.COL_MEMO, newDiary.getMemo());

        long count = db.insert(dbHelper.TABLE_NAME, null, value);
        dbHelper.close();
        if (count > 0) return true;
        return false;
    }

    public void close() {
        if (dbHelper != null) dbHelper.close();
        if (cursor != null) cursor.close();
    };
}