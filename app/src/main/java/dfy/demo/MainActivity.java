package dfy.demo;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.flyco.dialog.widget.popup.BubblePopup;

import butterknife.BindView;
import dfy.demo.bean.DetailBean;
import dfy.demo.presenter.HomeView;
import dfy.demo.presenter.homepresenter;
import dfy.demo.product.CarItemActiviy;
import dfy.demo.product.ChuZhiActivity;
import dfy.demo.widget.BaseDilog;

import static dfy.demo.ApplictionDemo.getActivityManager;


public class MainActivity extends BaseDemoActivity implements HomeView {

    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.button)
    TextView mButton;
    @BindView(R.id.but)
    TextView mBut;
    @BindView(R.id.lin)
    LinearLayout mLin;
    @BindView(R.id.tv_context)
    TextView mTvContext;

    private homepresenter mHomepresenter;


    @Override
    public void initView(Bundle savedInstanceState) {

        getActivityManager().pushActivity(this);
//        mHomepresenter = new homepresenter(this);
//        mHomepresenter.homeIndex();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, CarItemActiviy.class));
            }
        });

    }

    @Override
    public boolean isNetLoading() {
        return false;
    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_main;
    }


    @Override
    public void initData() {
        mHomepresenter = new homepresenter(this);
        mHomepresenter.homeIndex();
    }


    @Override
    public void getIndex(DetailBean homeBean) {
        System.out.println("加载成功了");
        loadSuccessView();
        mTvContext.setText(homeBean.getData().toString());

    }

    @Override
    public void fail() {
        loadingErrorView();
    }

    @Override
    public void setListener() {
        //储值
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(mContext, ChuZhiActivity.class));
               new BaseDilog.Builder(mContext)
                       .setMsgNotification()
                       .setMsg("YYY")
                       .setCancelListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               toastLong("xxx");
                           }
                       })
                       .setOkListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               toastLong("yyyyyy");
                           }
                       })
                       .show();

//                final BaseDilog baseDilog = new BaseDilog(mContext);
//                baseDilog.setContentView(R.layout.pouwidow);
//                baseDilog.show();
//
//                Window window = baseDilog.getWindow();
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                attributes.width=WindowManager.LayoutParams.MATCH_PARENT;
//                attributes.height=WindowManager.LayoutParams.WRAP_CONTENT;
//
//                attributes.gravity=Gravity.BOTTOM;
//                window.setAttributes(attributes);
//                baseDilog.setCancelable(false);
//                Button bt = baseDilog.findViewById(R.id.no);
//
//
//                bt.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        toastLong("ddssd");
//                        baseDilog.dismiss();
//                    }
//                });
            }
        });
    }

    private void myDialog(){
        new BaseDilog(mContext);
    }

    private void popupwindow(){
        View inflate = View.inflate(mContext, R.layout.rz_liucheng_layout, null);
        new BubblePopup(mContext, inflate)
                .anchorView(mBut)
                .bubbleColor(mContext.getResources().getColor(R.color.white))
                .gravity(Gravity.BOTTOM)
                .showAnim(null)
                .dismissAnim(null)
                .show();
        TextView viewById = inflate.findViewById(R.id.tv_tel);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastLong("sss");
            }
        });
    }


    private void itemDilog(){
        final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
        final ActionSheetDialog dialog = new ActionSheetDialog(mContext, stringItems, null);
        dialog.title("选择群消息提醒方式\r\n(该群在电脑的设置:接收消息并提醒)")//
                .titleTextSize_SP(14.5f)//
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                toastLong(stringItems[position]);
                dialog.dismiss();
            }
        });
    }

    private void Dialog() {
        NormalDialog materialDialog = new NormalDialog(mContext);
        materialDialog.content("yyyyy")
                .btnText("取消", "确定")
                .show();
        materialDialog.setOnBtnClickL(new OnBtnClickL() {
            @Override
            public void onBtnClick() {
                toastLong("点击了取消");
            }
        }, new OnBtnClickL() {
            @Override
            public void onBtnClick() {
                toastLong("点击了确定");
            }
        });

    }

}
