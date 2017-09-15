package dfy.demo.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.flyco.dialog.widget.popup.base.BaseBubblePopup;


import dfy.demo.R;


/**
 * Created by Admin on 2017/9/13.
 */

public class CustomBaseDialog extends BaseBubblePopup<CustomBaseDialog> {

    private Context mContext;

    private TextView mTextView;

    public CustomBaseDialog(Context context) {
        super(context);
        mContext=context;
    }

    @Override
    public View onCreateBubbleView() {
        return View.inflate(mContext,R.layout.pouwidow,null);
    }



    @Override
    public void setUiBeforShow() {

    }
}
