package ddwu.mobile.finalproject.ma02_20180963;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FoodDBManager {

    Cursor cursor = null;
    FoodDBHelper foodDBHelper;

    public FoodDBManager(Context context) { foodDBHelper = new FoodDBHelper(context); }

    public ArrayList<Food> getAllFood() {
        ArrayList foodList = new ArrayList();
        SQLiteDatabase db = foodDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME, null, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
            String foodName = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOODNAME));
            int img = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_IMG));

            foodList.add ( new Food(id, foodName, img));
        }

        cursor.close();
        foodDBHelper.close();
        return foodList;
    }

    public boolean addNewFood(Food newFood) {
        SQLiteDatabase db = foodDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(FoodDBHelper.COL_FOODNAME, newFood.getFoodName());
        value.put(FoodDBHelper.COL_IMG, newFood.getImg());

        long count = db.insert(FoodDBHelper.TABLE_NAME, null, value);
        foodDBHelper.close();
        if (count > 0) return true;
        return false;
    }

    public boolean removeFood(long id) {
        SQLiteDatabase sqLiteDatabase = foodDBHelper.getWritableDatabase();
        String whereClause = FoodDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = sqLiteDatabase.delete(FoodDBHelper.TABLE_NAME, whereClause,whereArgs);
        foodDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    public void close() {
        if (foodDBHelper != null) foodDBHelper.close();
        if (cursor != null) cursor.close();
    };
}
