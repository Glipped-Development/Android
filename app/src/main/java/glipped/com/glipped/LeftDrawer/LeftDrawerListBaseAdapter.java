package glipped.com.glipped.LeftDrawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import glipped.com.glipped.R;

/**
 * Created by root on 22/4/15.
 */
public class LeftDrawerListBaseAdapter extends BaseAdapter {

    //List of text elements in the drawer
    private ArrayList<String> elementTextList;
    //List of icons in the drawer
    private ArrayList<Integer> elementIconList;

    //Context of the calling activity
    private Context context;

    public LeftDrawerListBaseAdapter(ArrayList<String> elementTextList, ArrayList<Integer> elementIconList,
                              Context context) {

        this.elementTextList = elementTextList;
        this.elementIconList = elementIconList;
        this.context = context;
    }

    public static class ViewHolder {

        public TextView drawerListElementTextTextView;
        public ImageView drawerListIconImageView;
    }

    @Override
    public int getCount() {
        try {
            return elementTextList.size();
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return elementTextList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.drawer_list_template, parent, false);
            holder = new ViewHolder();

            holder.drawerListElementTextTextView = (TextView)
                    convertView.findViewById(R.id.drawer_list_element_text);
            holder.drawerListIconImageView = (ImageView)
                    convertView.findViewById(R.id.drawer_list_element_icon);

            convertView.setTag(holder);
            holder = (ViewHolder) convertView.getTag();
        } else
            holder = (ViewHolder) convertView.getTag();

        /**
         * Populate the list data over here
         */
        holder.drawerListElementTextTextView.setText(elementTextList.get(position));
        holder.drawerListIconImageView.setImageResource(elementIconList.get(position));

        return convertView;
    }
}
