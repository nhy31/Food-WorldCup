package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private static final int UPDATE_CODE = 200;
    private static final int REQ_CODE = 100;

    Food ResultFood;
    TextView textFoodName;
    ImageView imageFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ResultFood = (Food) getIntent().getSerializableExtra("result");

        textFoodName = findViewById(R.id.FoodName);
        textFoodName.setText(ResultFood.getFoodName());

        imageFood = findViewById(R.id.FoodImage);
        imageFood.setImageResource(ResultFood.getImg());

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.MapBtn:
                Intent intent1 = new Intent(ResultActivity.this, MapActivity.class);
                intent1.putExtra("result", ResultFood);
                startActivityForResult(intent1, UPDATE_CODE);
                break;

            case R.id.ListBtn:
                Intent intent = new Intent(ResultActivity.this, ListActivity.class);
                intent.putExtra("result", ResultFood);
                startActivityForResult(intent, UPDATE_CODE);
                break;
        }
    }
}
