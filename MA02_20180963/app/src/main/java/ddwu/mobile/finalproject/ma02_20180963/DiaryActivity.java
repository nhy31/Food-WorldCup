package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DiaryActivity extends AppCompatActivity {

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    DiaryAdapter Adapter;
    ArrayList<Diary> list = null;
    DiaryDBManager DBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_diary);

        listView = findViewById(R.id.lv_memo);
        list = new ArrayList();

        Adapter = new DiaryAdapter
                (this, R.layout.adapter_diary, list);

        listView.setAdapter(Adapter);

        DBManager = new DiaryDBManager(this);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                Intent intent1 = new Intent(DiaryActivity.this, AboutDiaryActivity.class);
                intent1.putExtra("selDiary", list.get(pos));
                startActivityForResult(intent1, REQ_CODE);
                return true;
            }
        });
    }

        @Override
        protected void onResume() {
            super.onResume();
            list.clear();
            list.addAll(DBManager.getAllDiary());
            Adapter.notifyDataSetChanged();
        }
    }


