package glipped.com.glipped.Tools.CustomTextViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by root on 21/4/15.
 */

/**
 * This class is a custom TextView which is used to implement the Lato type face
 */
public class LatoLiteTextView extends TextView {

    public LatoLiteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LatoLiteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoLiteTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/lato_light.ttf");
        setTypeface(tf ,1);

    }
}
