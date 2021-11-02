package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText etFoodName;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etFoodName = findViewById(R.id.et_name);
        foodDBManager = new FoodDBManager(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnok:
                // 필수항목(메뉴명)을 입력하지 않으면 입력 안내 토스트 출력
                if(etFoodName.getText().toString().equals("")) {
                    Toast.makeText(this, "메뉴명을 채워주세요.", Toast.LENGTH_LONG).show();
                }
                else {
                    boolean result = foodDBManager.addNewFood( new Food(etFoodName.getText().toString(), R.mipmap.we) );

                    if (result) {    // 정상수행에 따른 처리
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("food", etFoodName.getText().toString());
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    } else {        // 이상에 따른 처리
                        Toast.makeText(this, "새로운 음식메뉴 추가 실패!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btn_cancel:   // 취소에 따른 처리
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
