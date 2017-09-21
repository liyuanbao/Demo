package dfy.demo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;
import dfy.demo.widget.AddShopView;
import dfy.demo.widget.BaseDilog;
import dfy.demo.widget.ToolTitle;

/**
 * Created by Admin on 2017/9/4.
 */

public class DateChoseActivity extends BaseDemoActivity {


    @BindView(R.id.toolbar)
    ToolTitle mToolbar;
    @BindView(R.id.calendarView)
    MaterialCalendarView mCalendarView;
    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.tv_bm)
    TextView mTvBm;
    @BindView(R.id.tv_tel)
    TextView mTvTel;
    @BindView(R.id.bottom)
    LinearLayout mBottom;
    @BindView(R.id.tv_con)
    TextView mTvCon;
    @BindView(R.id.av_adult)
    AddShopView mAvAdult;
    @BindView(R.id.av_child)
    AddShopView mAvChild;

    private String money;
    BaseDilog.Builder mBuilder;

    @Override
    protected int getInflaterView() {
        return R.layout.activity_datechose;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mAvAdult.setTitleType("成人").setTwoVisiable(false);
        mAvChild.setTitleType("儿童").setTwoVisiable(false);

        mToolbar.setToolTitle("选择出游日期和人数")
                .setBackground(R.color.color_tool_bg_red)
                .setToolRightTwoVisable(false)
                .setToolRightOneVisiable(false)
                .setBackListener(this);

        Calendar c = Calendar.getInstance();
        mCalendarView.setDateSelected(c, true);
        mCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Calendar calendar = date.getCalendar();
                mTvDate.setText(calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日");
            }
        });

        CalendarDay selectedDate = mCalendarView.getSelectedDate();
        mTvDate.setText(selectedDate.getYear() + "年" + selectedDate.getMonth() + "月" + selectedDate.getDay() + "日");

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        //选择
        mAvAdult.addClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = mAvAdult.getNumber();
                i++;
                mAvAdult.setNumber(i+"");
            }
        }).jianClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAvAdult.getNumber()==0){
                    toastLong("已经最小值了");
                }else {
                    int i = mAvAdult.getNumber();
                    i--;
                    mAvAdult.setNumber(i+"");
                }
            }
        });
        mAvChild.addClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = mAvChild.getNumber();
                i++;
                mAvChild.setNumber(i+"");
            }
        }).jianClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAvChild.getNumber()==0){
                    toastLong("已经最小值了");
                }else {
                    int i = mAvChild.getNumber();
                    i--;
                    mAvChild.setNumber(i+"");
                }
            }
        });

        //选择套餐
        mTvCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, TaoCanChoseActivity.class));
            }
        });

        //明细

        mTvBm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBuilder = new BaseDilog.Builder(mContext);
                mBuilder.setInflaterView(R.layout.dialog_pricedetail)
                        .setShowMatchLocation()
                        .show();


            }
        });
    }

}
