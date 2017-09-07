package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.applandeo.materialcalendarview.CalendarView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.ToolTitle;
import dfy.networklibrary.base.BaseActivity;

/**
 * Created by Admin on 2017/9/4.
 */

public class DateChoseActivity extends BaseDemoActivity {
    private ToolTitle mToolbar;
    private MaterialCalendarView mCalendarView;
    private TextView mTvTaocanchose;
    private TextView mTvDate;


    @Override
    protected int getInflaterView() {
        return R.layout.activity_datechose;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mToolbar = (ToolTitle) findViewById(R.id.toolbar);
        mCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        mTvTaocanchose = (TextView) findViewById(R.id.tv_taocanchose);
        mTvDate = (TextView) findViewById(R.id.tv_date);

        mToolbar.setToolTitle("选择日期")
                .setBackground(R.color.color_tool_bg_red)
                .setToolRightTwoVisable(false)
                .setToolRightOneVisiable(false)
                .setBackListener(this);

        Calendar c = Calendar.getInstance();
        mCalendarView.setDateSelected(c,true);
        mCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Calendar calendar = date.getCalendar();
                mTvDate.setText(calendar.get(Calendar.YEAR)+"年"+(calendar.get(Calendar.MONTH)+1)+"月"+calendar.get(Calendar.DAY_OF_MONTH)+"日");
            }
        });

        CalendarDay selectedDate = mCalendarView.getSelectedDate();
        mTvDate.setText(selectedDate.getYear()+"年"+selectedDate.getMonth()+"月"+selectedDate.getDay()+"日");

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        //选择套餐
        mTvTaocanchose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,TaoCanChoseActivity.class));
            }
        });
    }

}
