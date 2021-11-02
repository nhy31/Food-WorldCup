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

public class DiaryAdapter extends BaseAdapter {

    static final String TAG = "MyAdapter";

    private Context context;
    private int layout;
    private ArrayList<Diary> myDataArrayList;
    private LayoutInflater layoutInflater;
    int count;

    public DiaryAdapter(Context context, int layout, ArrayList<Diary> myDataArrayList) {
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

    public void setList(ArrayList<Diary> list) {
        this.myDataArrayList = list;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        ViewHolder viewHolder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            viewHolder = new ViewHolder();

            Log.d(TAG, "getView2");

            viewHolder.FoodName = convertView.findViewById(R.id.FoodName);
            viewHolder.Date = convertView.findViewById(R.id.Date);
            viewHolder.FoodImage = convertView.findViewById(R.id.FoodImage);

            convertView.setTag(viewHolder);

            Log.d(TAG, "2count: " + ++count);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.FoodName.setText(myDataArrayList.get(pos).getFood());
        viewHolder.Date.setText(myDataArrayList.get(pos).getDate());

        int img = myDataArrayList.get(pos).getImg();
        viewHolder.FoodImage.setImageResource(img);
        return convertView;
    }

    static class ViewHolder {
        TextView FoodName;
        TextView Date;
        ImageView FoodImage;
    }
}
