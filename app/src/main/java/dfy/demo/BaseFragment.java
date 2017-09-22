package dfy.demo;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Admin on 2017/9/19.
 */

public  abstract class BaseFragment extends FragmentLazyLoad {




    public void loadSuccess(){

    }


    /**
     * 跳转到另一个Activity传Intent值
     * @param intent
     */
    public void beginActivity(Intent intent){
        startActivity(intent);
    }

    /**
     * 跳转到另一个Activity传Class值
     * @param clazz
     */
    public void beginActivity(Class clazz){
        Intent mIntent=new Intent(getContext(),clazz);
        startActivity(mIntent);
    }

    @Override
    public void loadFail() {

    }
}
