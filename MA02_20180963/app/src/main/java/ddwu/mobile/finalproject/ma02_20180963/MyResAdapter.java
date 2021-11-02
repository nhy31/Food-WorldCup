package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyResAdapter extends BaseAdapter {

    static  final String TAG = "MyAdapter";

    private Context context;
    private int layout;
    private ArrayList<NaverRestaurantDto> myDataArrayList;
    private LayoutInflater layoutInflater;
    int count;

    public MyResAdapter(Context context, int layout, ArrayList<NaverRestaurantDto> myDataArrayList) {
        this.context = context;
        this.layout = layout;
        this.myDataArrayList = myDataArrayList;
        count = 0;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDataArrayList.get(position).get_id();
    }

    public void setList(ArrayList<NaverRestaurantDto> list) {
        this.myDataArrayList = list;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        ViewHolder viewHolder;

        Log.d(TAG, "getView");

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.ResName= convertView.findViewById(R.id.FoodName);
            viewHolder.ResAddr = convertView.findViewById(R.id.ResAddr);
            convertView.setTag(viewHolder);

            Log.d(TAG, "count: " + ++count);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.ResName.setText(Html.fromHtml(myDataArrayList.get(pos).getTitle()));
        viewHolder.ResAddr.setText(myDataArrayList.get(pos).getAddress());
        return convertView;
    }

    static class ViewHolder {
        TextView ResName;
        TextView ResAddr;
    }




}
