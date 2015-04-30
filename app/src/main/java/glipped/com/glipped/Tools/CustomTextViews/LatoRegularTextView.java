package glipped.com.glipped.Tools.CustomTextViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by root on 22/4/15.
 */
public class LatoRegularTextView extends TextView {

    public LatoRegularTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LatoRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoRegularTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/lato_regular.ttf");
        setTypeface(tf ,1);

    }
}
