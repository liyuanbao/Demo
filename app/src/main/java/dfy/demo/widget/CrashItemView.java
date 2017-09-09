package dfy.demo.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import dfy.demo.R;

/**
 * Created by Admin on 2017/9/8.
 *
 * 储值/消费详情  条目分类
 */

public class CrashItemView extends RelativeLayout {

    private Context mContext;

    private TextView mTextOne;
    private TextView mTextTwo;
    private TextView mTextThree;
    private LinearLayout mRootView;

    public CrashItemView(Context context) {
        super(context);

        mContext=context;
        initView();
    }

    public CrashItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView();
    }

    public CrashItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        initView();
    }


    private void initView(){
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.crash_layout, this, true);
        mTextOne=inflate.findViewById(R.id.tv_one);
        mTextTwo=inflate.findViewById(R.id.tv_two);
        mTextThree=inflate.findViewById(R.id.tv_three);
        mRootView=inflate.findViewById(R.id.rootview);
    }


    /**
     * 设置字体颜色
     * @param resId
     * @return
     */
    public CrashItemView setTextColor(int resId){
        mTextOne.setTextColor(getResources().getColor(resId));
        mTextTwo.setTextColor(getResources().getColor(resId));
        mTextThree.setTextColor(getResources().getColor(resId));
        return this;
    }

    public CrashItemView setTvOneText(String str){
        mTextOne.setText(str);
        return this;
    }


    public CrashItemView setTvTwoText(String str){
        mTextTwo.setText(str);
        return this;
    }

    public CrashItemView setTvThreeText(String str){
        mTextThree.setText(str);
        return this;
    }

    /**
     * 设置全局背景图
     * @param resId
     * @return
     */
    public CrashItemView setBackground(int resId){
        mRootView.setBackgroundColor(getResources().getColor(resId));
        return this;
    }

    /**
     * 设置字体背景图
     * @param resId
     * @return
     */
    public CrashItemView setTextBackground(int resId){
        mTextOne.setBackgroundColor(getResources().getColor(resId));
        mTextTwo.setBackgroundColor(getResources().getColor(resId));
        mTextThree.setBackgroundColor(getResources().getColor(resId));
        return this;
    }

    /**
     * 点击监听
     * @param mOnClickListener
     * @return
     */
    public CrashItemView setClickOneListener(OnClickListener mOnClickListener){
        mTextOne.setOnClickListener(mOnClickListener);
        return this;
    }

    public CrashItemView setClickTwoListener(OnClickListener mOnClickListener){
        mTextTwo.setOnClickListener(mOnClickListener);
        return this;
    }

    public CrashItemView setClickThreeListener(OnClickListener mOnClickListener){
        mTextThree.setOnClickListener(mOnClickListener);
        return this;
    }
}
