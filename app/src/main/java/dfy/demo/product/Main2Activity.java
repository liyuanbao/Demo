package dfy.demo.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import dfy.demo.R;

public abstract class Main2Activity extends AppCompatActivity {
    RelativeLayout rvRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rvRoot= (RelativeLayout) findViewById(R.id.rv_root);

        rvRoot.addView(getLoadingView());
        if(getFirstData()){
            getData();
        }

    }

    protected int getDefalut(){
        return 1;
    }

    protected boolean getFirstData() {
        return true;
    }

    public void getData() {
        rvRoot.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(true){
                    dataSuccess();
                }else {
                    dataError();
                }

            }
        },2000);
    }

    protected void dataError() {
        rvRoot.removeAllViews();
        rvRoot.addView(getErrorView());
    }

    protected View getErrorView() {
        TextView tv=new TextView(this);
        tv.setText("错误了");
        return tv;
    }

    protected void dataSuccess(){
        rvRoot.removeAllViews();
        rvRoot.addView(getSuccessView());
    }

    protected abstract View getSuccessView();

    protected View getLoadingView() {
        TextView tv=new TextView(this);
        tv.setText("正在加载中");
        return tv;
    }
}
