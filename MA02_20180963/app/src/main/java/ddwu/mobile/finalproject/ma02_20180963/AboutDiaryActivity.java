package ddwu.mobile.finalproject.ma02_20180963;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutDiaryActivity extends AppCompatActivity {

    TextView selName;
    TextView selDate;
    TextView selDes;
    TextView memo;
    Diary select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        selName = findViewById(R.id.SelFood);
        selDate = findViewById(R.id.SelDate);
        selDes = findViewById(R.id.SelRes);
        memo = findViewById(R.id.Memo);

        select = (Diary) getIntent().getSerializableExtra("selDiary");

        selName.setText(select.getFood());
        selDate.setText(select.getDate());
        selDes.setText(select.getRes());
        memo.setText(select.getMemo());
    }
}
