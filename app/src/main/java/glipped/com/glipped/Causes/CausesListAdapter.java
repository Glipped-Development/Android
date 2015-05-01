package glipped.com.glipped.Causes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import glipped.com.glipped.R;

/**
 * Created by kartikey on 1/5/15.
 */
public class CausesListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> causeNameList;
    private ArrayList<Integer> causeImagePathList;

    public CausesListAdapter(Context context, ArrayList<String> causeNameList,
                             ArrayList<Integer> causeImagePathList) {

        this.context = context;
        this.causeNameList = causeNameList;
        this.causeImagePathList = causeImagePathList;
    }

    @Override
    public int getCount() {
        if(this.causeNameList != null)
            return this.causeNameList.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        return causeNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewContainer = null;

        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.cause_list_template, null);
            viewContainer = new ViewHolder();
            viewContainer.causeTitle =
                    (glipped.com.glipped.Tools.CustomTextViews.LatoLiteTextView)
                            convertView.findViewById(R.id.cause_list_template_text_holder);
            viewContainer.causeImage =
                    (ImageView) convertView.findViewById(R.id.cause_list_template_image_holder);
            convertView.setTag(viewContainer);
        } else
            viewContainer = (ViewHolder) convertView.getTag();

        //Populate with values
        viewContainer.causeTitle.setText(causeNameList.get(position));
        viewContainer.causeImage.setImageResource(causeImagePathList.get(position));

        return convertView;
    }

    public static class ViewHolder {

        public glipped.com.glipped.Tools.CustomTextViews.LatoLiteTextView causeTitle;
        public ImageView causeImage;
    }
}
