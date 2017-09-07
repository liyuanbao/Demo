package dfy.demo.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import dfy.demo.R;

public class Main3Activity extends Main2Activity {
    @Override
    protected View getSuccessView() {
        TextView tv=new TextView(this);
        tv.setText("成功了");

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
        return tv;
    }

    @Override
    protected boolean getFirstData() {
        return false;
    }
}
