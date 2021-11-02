package ddwu.mobile.finalproject.ma02_20180963;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyFoodAdapter extends BaseAdapter {

    static  final String TAG = "MyAdapter";

    private Context context;
    private  int layout;
    private ArrayList<Food> myDataArrayList;
    private LayoutInflater layoutInflater;
    int count;

    public MyFoodAdapter(Context context, int layout, ArrayList<Food> myDataArrayList) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        ViewHolder viewHolder;

        Log.d(TAG, "getView");

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.foodName = convertView.findViewById(R.id.FoodName);
            viewHolder.foodImg = convertView.findViewById(R.id.FoodImage);
            convertView.setTag(viewHolder);

            Log.d(TAG, "count: " + ++count);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.foodName.setText(myDataArrayList.get(pos).getFoodName());

        int img = myDataArrayList.get(pos).getImg();
        viewHolder.foodImg.setImageResource(img); //오류

        return convertView;
    }

    static class ViewHolder {
        TextView foodName;
        ImageView foodImg;
    }
}
