package ddwu.mobile.finalproject.ma02_20180963;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    EditText etTarget;
    ListView lvList;
    String apiAddress;

    String query;
    Button button;

    MyResAdapter adapter;
    ArrayList<NaverRestaurantDto> resultList;
    NaverRestaurantXmlParser parser;
    NaverNetworkManager networkManager;

    Food ResultFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_resturant);

        ResultFood = (Food) getIntent().getSerializableExtra("result");

        etTarget = findViewById(R.id.textView3);;
        etTarget.setText("월곡 " + ResultFood.getFoodName() + " 맛집 ");
        lvList = findViewById(R.id.listView_res);

        resultList = new ArrayList();
        adapter = new MyResAdapter(this, R.layout.adapter_restaurant,
                resultList);
        lvList.setAdapter(adapter);

        button = findViewById(R.id.button);

        apiAddress = getResources().getString(R.string.api_url);
        parser = new NaverRestaurantXmlParser();
        networkManager = new NaverNetworkManager(this);
        networkManager.setClientId(getResources().getString(R.string.client_id));
        networkManager.setClientSecret(getResources().getString(R.string.client_secret));

        lvList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int pos = position;
                Intent intent1 = new Intent(ListActivity.this, AboutResActivity.class);
                intent1.putExtra("select", resultList.get(pos));
                startActivityForResult(intent1, REQ_CODE);

                return true;
            }
        });
    }

    public void onClick(View v) throws UnsupportedEncodingException {
        switch(v.getId()) {
            case R.id.button:
                query = etTarget.getText().toString();   // UTF-8 인코딩 필요
                try {
                    new NaverAsyncTask().execute(apiAddress + URLEncoder.encode(query, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.MapBtn:
                Intent intent1 = new Intent(ListActivity.this, MapActivity.class);
                intent1.putExtra("resultList", resultList);
                intent1.putExtra("result", ResultFood);
                startActivityForResult(intent1, UPDATE_CODE);
                break;
        }
    }

    class NaverAsyncTask extends AsyncTask<String, Integer, String> {
        ProgressDialog progressDlg;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDlg = ProgressDialog.show(
                    ListActivity.this, "Wait", "Downloading...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String address = strings[0];
            String result = null;

            // networking
            result = networkManager.downloadContents(address);
            if (result == null) return  "Error!";

            //parsing
            resultList = parser.parse(result);

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            adapter.setList(resultList);
            progressDlg.dismiss();
        }
    }
}
