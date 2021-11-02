package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutResActivity extends AppCompatActivity {

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    TextView selName;
    TextView selCate;
    TextView selAddr;
    TextView selRoadAddr;
    TextView selDes;
    TextView selLink;
    TextView selXY;
    NaverRestaurantDto select;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        img = findViewById(R.id.diaryImage);

        selName = findViewById(R.id.SelectName);
        selAddr = findViewById(R.id.SelRes);
        selRoadAddr = findViewById(R.id.SelectRoadAddr);
        selLink = findViewById(R.id.SelLink);
        selCate = findViewById(R.id.SelDate);
        selDes= findViewById(R.id.SelFood);
        selXY = findViewById(R.id.SelXY);

        select = (NaverRestaurantDto) getIntent().getSerializableExtra("select");

        if(select.getTitle() != null) {
            selName.setText(Html.fromHtml(select.getTitle()));
        }

        if(select.getAddress() != null) {
            selAddr.setText(select.getAddress());
        }

        if(select.getRoadAddress() != null) {
            selRoadAddr.setText(select.getRoadAddress());
        }
        if(select.getCategory() != null) {
            selCate.setText(select.getCategory());
        }
        if(select.getDescription() != null) {
            selDes.setText(select.getDescription());
        }
        if(select.getLink() != null) {
            selLink.setText(select.getLink());
        }

        String s = select.getMapy() + ", " + select.getMapy();
        if(s != null) {
            selXY.setText(s);
        }

        img.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View view) {
              Intent intent1 = new Intent(AboutResActivity.this, DiaryActivity.class);
              startActivityForResult(intent1, REQ_CODE);
            }

        });
    }

}
