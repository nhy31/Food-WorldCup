package ddwu.mobile.finalproject.ma02_20180963;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.StartBtn:
                Intent intent1 = new Intent(MainActivity.this, FoodChoiceActivity.class);
                startActivityForResult(intent1, REQ_CODE);
                break;
        }

    }

    // 메뉴생성
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        switch(item.getItemId()) {
            case R.id.del_food:
                Intent intent2 = new Intent(this, DelActivity.class);
                startActivityForResult(intent2, REQ_CODE);
                break;
            case R.id.add_food:
                Intent intent3 = new Intent(this, AddActivity.class);
                startActivityForResult(intent3, REQ_CODE);
                break;
            case R.id.app_introduce:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("앱 '오늘 뭐먹지?' 소개")
                        .setIcon(R.mipmap.f1)
                        .setMessage("이 앱은 모바일응용 02분반 컴퓨터학과 20180963 나하윤이 개발하였습니다.\n" +
                                "이 앱은 동덕여대 학생들이 공강 시간에 먹을 음식 메뉴를 정하는 데 도움을 주기위해 만들어졌습니다.\n" +
                                "월드컵 게임을 통해 선택된 음식의 맛집 정보 제공과 바쁜 현대인, 동덕인을 위해서 현재 위치를 기반으로 한 식당 정보를 제공합니다.\n")
                        .setPositiveButton("뒤로 가기", null)
                        .setCancelable(false)
                        .show();
                break;
            case R.id.app_finish:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("앱 종료")
                        .setMessage("앱을 종료하시겠습니까?")
                        .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .setNegativeButton("취소", null)
                        .show();
                break;
        }
        return true;
    }
}