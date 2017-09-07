package dfy.demo.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import dfy.demo.R;

/**
 * Created by Admin on 2017/9/7.
 */

public class RZLiuChengView extends RelativeLayout {

    private TextView mTvTel;
    private View mVTel;
    private TextView mTvName;
    private View mVName;
    private TextView mTvPass;
    private View mVPass;
    private TextView mTvChuzhi;



    private Context mContext;
    public RZLiuChengView(Context context) {
        super(context);
        mContext=context;
        initView();
    }

    public RZLiuChengView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView();
    }

    public RZLiuChengView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
    }

    protected void initView(){

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.rz_liucheng_layout, this, true);
        mTvTel = (TextView) findViewById(R.id.tv_tel);
        mVTel = (View) findViewById(R.id.v_tel);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mVName = (View) findViewById(R.id.v_name);
        mTvPass = (TextView) findViewById(R.id.tv_pass);
        mVPass = (View) findViewById(R.id.v_pass);
        mTvChuzhi = (TextView) findViewById(R.id.tv_chuzhi);
    }

    /**
     * 设置电话认证流程
     * @param drawable
     * @param color
     * @return
     */
    public RZLiuChengView setTelColor(Drawable drawable,int color){
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        mTvTel.setCompoundDrawables(null,drawable,null,null);
        mTvTel.setTextColor(mContext.getResources().getColor(color));
        return this;
    }

    /**
     * 设置实名验证流程
     * @param drawable
     * @param color
     * @return
     */
    public RZLiuChengView setNameColor(Drawable drawable,int color){
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        mTvName.setCompoundDrawables(null,drawable,null,null);
        mTvName.setTextColor(mContext.getResources().getColor(color));
        mVTel.setBackgroundColor(mContext.getResources().getColor(color));
        return this;
    }

    /**
     * 密码设置流程
     * @param drawable
     * @param color
     * @return
     */
    public RZLiuChengView setPassColor(Drawable drawable,int color){
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        mTvPass.setCompoundDrawables(null,drawable,null,null);
        mTvPass.setTextColor(mContext.getResources().getColor(color));
        mVName.setBackgroundColor(mContext.getResources().getColor(color));
        return this;
    }

    /**
     * 储蓄流程
     * @param drawable
     * @param color
     * @return
     */
    public RZLiuChengView setChuZhiColor(Drawable drawable,int color){
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        mTvChuzhi.setCompoundDrawables(null,drawable,null,null);
        mTvChuzhi.setTextColor(mContext.getResources().getColor(color));
        mVPass.setBackgroundColor(mContext.getResources().getColor(color));
        return this;
    }

    /**
     * 认证电话监听
     * @param mOnClick
     * @return
     */
    public RZLiuChengView setTelOnClickListener(OnClickListener mOnClick){
        mTvTel.setOnClickListener(mOnClick);
        return this;
    }
    /**
     * 实名验证
     * @param mOnClick
     * @return
     */
    public RZLiuChengView setNameOnClickListener(OnClickListener mOnClick){
        mTvName.setOnClickListener(mOnClick);
        return this;
    }

    /**
     * 密码设置
     * @param mOnClick
     * @return
     */
    public RZLiuChengView setPassOnClickListener(OnClickListener mOnClick){
        mTvPass.setOnClickListener(mOnClick);
        return this;
    }


    /**
     * 储蓄
     * @param mOnClick
     * @return
     */
    public RZLiuChengView setChuXuOnClickListener(OnClickListener mOnClick){
        mTvPass.setOnClickListener(mOnClick);
        return this;
    }
}
