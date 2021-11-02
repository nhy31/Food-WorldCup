package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class FoodChoiceActivity<TAG> extends AppCompatActivity {

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;
    int i;

    ImageView imageView_left;
    ImageView imageView_right;
    TextView foodName_left;
    TextView foodName_right;

    ArrayList<Food> foodList = null;
    ArrayList<Food> ChoiceList = null;
    FoodDBManager foodDBManager;
    Food ChoiceItem = null;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_choice);

        imageView_left = findViewById(R.id.imageView_left);
        imageView_right = findViewById(R.id.imageView_right);

        foodName_left = findViewById(R.id.foodName_left);
        foodName_right = findViewById(R.id.foodName_right);

        foodList = new ArrayList();
        ChoiceItem = new Food();
        ChoiceList = new ArrayList();

        foodDBManager = new FoodDBManager(this);
        foodList = foodDBManager.getAllFood();

        if (foodList.size() == 4 || foodList.size() == 8
                || foodList.size() == 16 || foodList.size() == 32) {
            Toast.makeText(this, "현재 음식 메뉴의 개수는 " + foodList.size() + "개 입니다. " +
                    "월드컵을 시작할 수 있습니다. " + foodList.size() + "강 입니다.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "현재 음식 메뉴의 개수는 " + foodList.size() + "개 입니다. " +
                    "월드컵을 시작하려면 음식메뉴의 개수는 2의 제곱수여야 합니다.(최소 4, 최대 32개)" +
                    "메인 화면의 메뉴를 통해 음식 메뉴를 추가 또는 삭제해주세요. ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        ChoiceList = new ArrayList<>();

        if(foodList.size() == 2) {
            i = -1;
        }

        else {
            imageView_left.setImageResource(foodList.get(0).getImg());
            imageView_right.setImageResource(foodList.get(1).getImg());
            foodName_left.setText(foodList.get(0).getFoodName());
            foodName_right.setText(foodList.get(1).getFoodName());

            imageView_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ChoiceItem.setFoodName(foodList.get(0).getFoodName());
                    ChoiceItem.setImg(foodList.get(0).getImg());
                    ChoiceList.add(ChoiceItem);
                    Toast.makeText(FoodChoiceActivity.this,
                            ChoiceItem.getFoodName() + "선택", Toast.LENGTH_SHORT).show();

                }
            });

            imageView_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ChoiceItem.setFoodName(foodList.get(1).getFoodName());
                    ChoiceItem.setImg(foodList.get(1).getImg());
                    ChoiceList.add(ChoiceItem);
                    Toast.makeText(FoodChoiceActivity.this,
                            ChoiceItem.getFoodName() + "선택", Toast.LENGTH_SHORT).show();
                }
            });
            i = 1;
        }
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.NextBtn:
                if (i == foodList.size() / 2) {
                    if(foodList.size() / 2 == 2) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(FoodChoiceActivity.this);
                        builder.setTitle("★ 마지막 월드컵 ★")
                                .setMessage("결승전입니다!")
                                .show();
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(FoodChoiceActivity.this);
                        builder.setTitle("♥ 월드컵 진행 중 ♥")
                                .setMessage(foodList.size() / 2 + "강 입니다")
                                .show();
                    }
                    foodList.clear();
                    foodList.addAll(ChoiceList);
                    ChoiceList.clear();
                    i = 0;
                }

                if (i == -1) {
                    Button button;
                    button = findViewById(R.id.ResultBtn);
                    button.setClickable(true);
                    button.setVisibility(View.VISIBLE);
                    button.setText("결과보기");

        }

                if(i != -1) {
                    i = food_choice(foodList, 2 * i, 2 * i + 1);
                }
                break;

            case R.id.ResultBtn:
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("result", ChoiceItem);
                startActivity(intent);
                break;

        }

    }

    public int food_choice(ArrayList<Food> list, int n1, int n2) {
        imageView_left.setImageResource(list.get(n1).getImg());
        imageView_right.setImageResource(list.get(n2).getImg());
        foodName_left.setText(list.get(n1).getFoodName());
        foodName_right.setText(list.get(n2).getFoodName());

        imageView_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChoiceItem = new Food();
                ChoiceItem.setFoodName(list.get(n1).getFoodName());
                ChoiceItem.setImg(list.get(n1).getImg());
                ChoiceList.add(ChoiceItem);
                Toast.makeText(FoodChoiceActivity.this, ChoiceItem.getFoodName() + "선택", Toast.LENGTH_SHORT).show();
            }
        });

        imageView_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChoiceItem = new Food();
                ChoiceItem.setFoodName(list.get(n2).getFoodName());
                ChoiceItem.setImg(list.get(n2).getImg());
                ChoiceList.add(ChoiceItem);
                Toast.makeText(FoodChoiceActivity.this, ChoiceItem.getFoodName() + "선택", Toast.LENGTH_SHORT).show();
            }
        });
        i++;

        if (list.size() == 2) {
            return -1;
        }

        return i;
    }
}
