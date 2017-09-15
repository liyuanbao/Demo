package dfy.demo.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import dfy.demo.BaseDemoActivity;
import dfy.demo.R;

/**
 * Created by Admin on 2017/9/14.
 */

public class ARShowActivity extends BaseDemoActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.vr_view)
    VrPanoramaView mVrView;

    @Override
    public void initView(Bundle savedInstanceState) {


        /**获取assets文件夹下的图片**/
        InputStream open = null;
        try {
            open = getAssets().open("aa.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(open);
        /**设置加载VR图片的相关设置**/
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
        /**设置加载VR图片监听**/
        mVrView.setEventListener(new VrPanoramaEventListener() {
            /**
             * 显示模式改变回调
             * 1.默认
             * 2.全屏模式
             * 3.VR观看模式，即横屏分屏模式
             * @param newDisplayMode 模式
             */
            @Override
            public void onDisplayModeChanged(int newDisplayMode) {
                super.onDisplayModeChanged(newDisplayMode);
                Log.d("TAG", "onDisplayModeChanged()->newDisplayMode=" + newDisplayMode);
            }

            /**
             * 加载VR图片失败回调
             * @param errorMessage
             */
            @Override
            public void onLoadError(String errorMessage) {
                super.onLoadError(errorMessage);
                Log.d("TAG", "onLoadError()->errorMessage=" + errorMessage);
            }

            /**
             * 加载VR图片成功回调
             */
            @Override
            public void onLoadSuccess() {
                super.onLoadSuccess();
                Log.d("TAG", "onLoadSuccess->图片加载成功");
            }

            /**
             * 点击VR图片回调
             */
            @Override
            public void onClick() {
                super.onClick();
                Log.d("TAG", "onClick()");
            }
        });
        /**加载VR图片**/
        mVrView.loadImageFromBitmap(bitmap, options);
    }

    @Override
    public void initData() {

    }

    @Override
    protected int getInflaterView() {
        return R.layout.activity_arshow;
    }
}
