package dfy.demo.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.service.quicksettings.Tile;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Set;

import dfy.demo.R;
import dfy.networklibrary.App;

/**
 * Created by Admin on 2017/9/4.
 */

public class ToolTitle extends RelativeLayout {

    private RelativeLayout mTool;
    private TextView mToolBeack;
    private TextView mToolText;
    private TextView mToolOne;
    private TextView mToolTwo;

    private View mRootView;
    private Context mContext;

    public ToolTitle(Context context) {
        super(context);
        mContext = context;
        initView(context);
    }

    public ToolTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView(context);
    }

    public ToolTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView(context);
    }

    public void initView(Context mContext) {
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.title_azj, this, true);
        mTool = mRootView.findViewById(R.id.tool);
        mToolBeack = mRootView.findViewById(R.id.tool_back);
        mToolText = mRootView.findViewById(R.id.tool_text);
        mToolOne = mRootView.findViewById(R.id.right_one);
        mToolTwo = mRootView.findViewById(R.id.right_two);
    }


    public ToolTitle setBackground(int id) {
        mTool.setBackgroundColor(getResources().getColor(id));
        return this;
    }

    /**
     * 点击监听
     *
     * @param mOnClickListener
     */
    public ToolTitle setRightOneListener(OnClickListener mOnClickListener) {
        mToolOne.setOnClickListener(mOnClickListener);
        return this;
    }

    public ToolTitle setRightTwoListener(OnClickListener mOnClickListener) {
        mToolTwo.setOnClickListener(mOnClickListener);
        return this;
    }

    public ToolTitle setBackListener(final Activity activity) {
        mToolBeack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
        return this;
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public ToolTitle setToolTitle(String title) {
        mToolText.setText(title);
        return this;
    }

    /**
     * 设置图标
     *
     * @param id
     */
    public ToolTitle setRightOneDrawable(int id) {
        Drawable drawable = ContextCompat.getDrawable(mContext, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mToolOne.setCompoundDrawables(drawable, null, null, null);
        return this;
    }

    public ToolTitle setRightTwoDrawable(int id) {
        Drawable drawable = ContextCompat.getDrawable(mContext, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mToolTwo.setCompoundDrawables(drawable, null, null, null);
        return this;
    }

    /**
     * @param text
     */
    public ToolTitle setRightOneText(String text) {
        mToolOne.setCompoundDrawables(null, null, null, null);
        mToolOne.setText(text);
        return this;
    }

    /**
     * @param text
     */
    public ToolTitle setRightTwoText(String text) {
        mToolTwo.setCompoundDrawables(null, null, null, null);
        mToolTwo.setText(text);
        return this;
    }

    /**
     * 设置显示
     *
     * @param ishow
     */
    public ToolTitle setBackVisiable(boolean ishow) {
        if (ishow) mToolBeack.setVisibility(VISIBLE);
        mToolBeack.setVisibility(GONE);
        return this;
    }

    public ToolTitle setToolTextVisiable(boolean ishow) {
        if (ishow) mToolText.setVisibility(VISIBLE);
        mToolText.setVisibility(GONE);
        return this;
    }

    public ToolTitle setToolRightOneVisiable(boolean ishow) {
        if (ishow) mToolOne.setVisibility(VISIBLE);
        mToolOne.setVisibility(GONE);
        return this;
    }

    public ToolTitle setToolRightTwoVisable(boolean ishow) {
        if (ishow) mToolTwo.setVisibility(VISIBLE);
        mToolTwo.setVisibility(GONE);
        return this;
    }
}
