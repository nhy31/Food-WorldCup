package ddwu.mobile.finalproject.ma02_20180963;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DelActivity extends AppCompatActivity {

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    MyFoodAdapter myFoodAdapter;
    ArrayList<Food> foodList = null;
    FoodDBManager foodDBManager;

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_del);

        listView = findViewById(R.id.listView);
        foodList = new ArrayList();

        myFoodAdapter = new MyFoodAdapter(this, R.layout.adapter_food, foodList);
        listView.setAdapter(myFoodAdapter);

        foodDBManager = new FoodDBManager(this);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(DelActivity.this);
                builder.setTitle("음식 삭제")
                        .setMessage(foodList.get(pos).getFoodName() + " 음식을 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (foodDBManager.removeFood(foodList.get(pos).get_id())) {
                                    Toast.makeText(DelActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    foodList.clear();
                                    foodList.addAll(foodDBManager.getAllFood());
                                    myFoodAdapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(DelActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        foodList.clear();
        foodList.addAll(foodDBManager.getAllFood());
        myFoodAdapter.notifyDataSetChanged();
    }
}
