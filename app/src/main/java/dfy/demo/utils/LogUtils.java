package dfy.demo.utils;

import android.nfc.tech.IsoDep;
import android.util.Log;
import android.util.Xml;

/**
 * Created by Admin on 2017/9/15.
 */

public class LogUtils {

    public static final String LOG_WARN="WARN";
    public static final String LOG_ERROR="ERROR";
    public static final String LOG_DEGUG="DEBUG";

    /**
     * @return
     * 发布版本设置为false
     */
    public static boolean isDebug(){
        return true;
    }


    public static void w(String msg){
        if (isDebug()){
            Log.w(LOG_WARN,msg);
        }
    }

    public static void e(String msg){
        if (isDebug()){
            Log.e(LOG_ERROR,msg);
        }
    }

    public static void d(String msg){
        if (isDebug()){
            Log.d(LOG_DEGUG,msg);
        }
    }


}
