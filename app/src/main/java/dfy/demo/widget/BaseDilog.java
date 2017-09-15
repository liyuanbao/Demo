package dfy.demo.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import dfy.demo.R;

/**
 * Created by Admin on 2017/9/13.
 */

public class BaseDilog {

    public String title;
    public String msg;
    public String cancel;
    public String ok;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public static class Builder extends Dialog {
        private Context mContext;
        private Button mYes;
        private Button mNo;
        private TextView mMsg;
        private TextView mTitle;


        public Builder(@NonNull Context context) {
            super(context, R.style.MyDialog);
            this.mContext=context;
        }

        public Builder(@NonNull Context context, @StyleRes int themeResId) {
            super(context, themeResId);
        }

        protected Builder(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
            super(context, cancelable, cancelListener);
        }

        public BaseDilog.Builder setInflaterView(int resLayId){
            View inflate = LayoutInflater.from(mContext).inflate(resLayId, null);
            this.setContentView(inflate);
            return this;
        }

        public BaseDilog.Builder setCancelTouch(boolean isShow){
            if (isShow){//点击其他区域不可消失，只有点击Dialog试图内
                this.setCanceledOnTouchOutside(false);
            }else {//点击任何区域消失
                this.setCanceledOnTouchOutside(true);
            }
            return this;
        }

        public BaseDilog.Builder setMsgNotification(){
            setContentView(R.layout.pouwidow);
            mTitle=findViewById(R.id.title);
            mMsg=findViewById(R.id.message);
            mYes=findViewById(R.id.yes);
            mNo=findViewById(R.id.no);
            mTitle.setVisibility(View.VISIBLE);
            return this;
        }


        /**
         * 没有标题
         * @param ishow
         * @return
         */
        public Builder setTitleShow(boolean ishow) {
            if (ishow){
                mTitle.setVisibility(View.VISIBLE);
            }else {
                mTitle.setVisibility(View.INVISIBLE);
            }
            return this;
        }

        /**
         * 标题
         * @param title
         * @return
         */
        public Builder setTitle(String title) {
           if (mTitle!=null){
               mTitle.setText(title);
           }
            return this;
        }

        /**
         * 内容
         * @param msg
         * @return
         */
        public Builder setMsg(String msg) {
            if (mMsg!=null){
                mMsg.setText(msg);
            }
            return this;
        }

        /**
         * 取消
         * @param mOnClick
         * @return
         */
        public Builder setCancelListener(View.OnClickListener mOnClick) {
            if (mNo!=null){
                mNo.setOnClickListener(mOnClick);
            }
            return this;
        }

        /**
         * 内容
         * @param mOnClick
         * @return
         */
        public Builder setOkListener(View.OnClickListener mOnClick) {
            if (mYes!=null){
                mYes.setOnClickListener(mOnClick);
            }
            return this;
        }

        /**
         * 设置在底部占满全屏弹出
         * @return
         */
        public BaseDilog.Builder setShowBottomMatchLocation(){
            Window window = this.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width=WindowManager.LayoutParams.MATCH_PARENT;
            attributes.height=WindowManager.LayoutParams.WRAP_CONTENT;
            attributes.gravity= Gravity.BOTTOM;
            window.setAttributes(attributes);
            return this;
        }

        public BaseDilog.Builder setAnimation(){
            Window window = this.getWindow();
            window.setWindowAnimations(R.style.mystyle);
            return this;
        }

    }
}
