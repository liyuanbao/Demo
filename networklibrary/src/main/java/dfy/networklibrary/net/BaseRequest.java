package dfy.networklibrary.net;

import android.content.Intent;
import android.util.Log;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Set;


import dfy.networklibrary.App;
import dfy.networklibrary.base.BaseView;
import dfy.networklibrary.loadingdialog.view.LoadingDialog;

/**
 * Created by Admin on 2017/8/30.
 */

public class BaseRequest<T extends BaseBean> {

    public static int JSON_PARE = 0;//解析失败
    //请求url
    private String URL;
    //请求参数
    private HashMap<String, String> httpParams;

    //设置是否需要加载进行中进度
    private boolean isLoading = false;
    private boolean isJsonException = true;
    private Gson mGson;
    //json解析数据类型
    private Class<T> clazz;
    //请求成功
    private NetRequestSuccess mRequestSuccess;
    private NetRequestData mRequestData;
    //加载弹出框(弹出框设置)
    private LoadingDialog mLoadingDialog;
    LoadingDialog.Speed speed = LoadingDialog.Speed.SPEED_TWO;
    private boolean intercept_back_event = false;//是否拦截返回键
    private int repeatTime = 0;
    private boolean isFirstLoading = false;

    //网络请求失败
    private LoadingFailed mLoadingFailed;


    public BaseRequest() {
        mGson = new Gson();
        mLoadingDialog = new LoadingDialog(App.getActivityManager().currentActivity());
    }

    /**
     * 设置地址
     *
     * @param url
     * @return
     */
    public BaseRequest setURL(String url) {
        this.URL = url;
        return this;
    }

    /**
     * 添加的请求参数
     *
     * @param httpParams
     * @return
     */
    public BaseRequest addHttpParams(HashMap<String, String> httpParams) {
        this.httpParams = httpParams;
        return this;
    }

    public BaseRequest setLoadingFailed(LoadingFailed loadingFailed) {
        mLoadingFailed = loadingFailed;
        return this;
    }

    /**
     * 获取解析的数据类型
     *
     * @param clazz
     * @return
     */
    public BaseRequest setDataType(Class<T> clazz) {
        this.clazz = clazz;
        return this;
    }

    /**
     * 设置加载静读条
     *
     * @param isLoading
     * @return
     */
    public BaseRequest setIsLoading(boolean isLoading) {
        this.isLoading = isLoading;
        return this;
    }

    /**
     * 设置解析异常是否弹出对话框
     *
     * @param isJsonException
     * @return
     */
    public BaseRequest setIsJsonException(boolean isJsonException) {
        this.isJsonException = isJsonException;
        return this;
    }

    /**
     * 请求成功
     *
     * @param netRequestSuccess
     * @return
     */
    public BaseRequest requestCodeSuccess(NetRequestSuccess netRequestSuccess) {
        this.mRequestSuccess = netRequestSuccess;
        return this;
    }

    public BaseRequest requesetNoCodeSucess(NetRequestData netRequestData) {
        this.mRequestData = netRequestData;
        return this;
    }


    public BaseRequest setFirstLoading(boolean firstLoading) {
        isFirstLoading = firstLoading;
        return this;
    }

    public void netGetRequest() {
        if (!NetworkUtils.isConnected()) {
            //如果进入某个页面就加载网络
            if (isFirstLoading) {
                mLoadingFailed.loadFailed();
            } else if (isLoading) {
                mLoadingDialog
                        .setInterceptBack(intercept_back_event)
                        .setLoadSpeed(speed)
                        .closeSuccessAnim()
                        .setRepeatCount(repeatTime)
                        .show();
                mLoadingDialog.loadNetFailed();
            }
            return;
        }
        printURL();
        OkGo.<String>get(URL)
                .tag(this)
                .params(httpParams)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (isLoading) {
                            mLoadingDialog.setLoadingText("加载中...")
                                    .setLoadSpeed(speed)
                                    .closeSuccessAnim()
                                    .setRepeatCount(repeatTime)
                                    .show();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        //加载成功
//                        if (isLoading) {
//                            mLoadingDialog.loadSuccess();
//                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                        if (isFirstLoading) {
                            mLoadingFailed.loadFailed();
                        } else if (isLoading) {
                            System.out.println("执行失败");
                            mLoadingDialog.loadRequestFailed();
                        }
                    }

                    @Override
                    public void onSuccess(Response<String> response) {

                        if (mGson == null) mGson = new Gson();
                        T dataType = null;
                        try {
                            dataType = mGson.fromJson(response.body(), clazz);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e(ConstantNet.JSONEXCEPTION, e.getMessage());
                            if (isJsonException) {
                                if (mLoadingDialog != null) {
                                    mLoadingDialog.loadJsonFailed();
                                }
                            }
                        } finally {
                            printJson(response.body());
                        }
                        //解析成功
                        if (dataType != null) {
                            if (isLoading) {
                                mLoadingDialog.loadSuccess();
                            }
                            //返回全部数据
//                            mRequestSuccess.needResultCode(dataType);
                            if (dataType.getCode() == ConstantNet.RESPONCE_CODE_INVALID) {
                                //当返回码为多少时，账号失效，此时需要用户重新登陆，清空用户信息
                            } else if (dataType.getCode() == ConstantNet.RESPONCE_CODE_SERVICE) {
                                //服务其错误
                            } else {
                                //返回用户数据
                                mRequestSuccess.needResultCode(dataType);
                            }
                        } else {//解析失败
                            if (isJsonException) {
                                if (mLoadingDialog != null) {
                                    mLoadingFailed.loadFailed();
//                                    mLoadingDialog.loadJsonFailed();
                                }
                            }
                        }
                    }
                });
    }

    /**
     * post方式进行网络请求
     */
    public void netPostRequest() {

        if (!NetworkUtils.isConnected()) {
            //如果进入某个页面就加载网络
            if (isFirstLoading) {
                mLoadingFailed.loadFailed();
            } else if (isLoading) {
                mLoadingDialog
                        .setInterceptBack(intercept_back_event)
                        .setLoadSpeed(speed)
                        .closeSuccessAnim()
                        .setRepeatCount(repeatTime)
                        .show();
                mLoadingDialog.loadNetFailed();
            }
            return;
        }

        printURL();

        OkGo.<String>post(URL)
                .tag(this)
                .params(httpParams)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (isLoading) {
                            mLoadingDialog.setLoadingText("加载中...")
                                    .setLoadSpeed(speed)
                                    .closeSuccessAnim()
                                    .setRepeatCount(repeatTime)
                                    .show();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        //加载成功
//                        if (isLoading) {
//                            mLoadingDialog.loadSuccess();
//                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        if (isFirstLoading) {
                            mLoadingFailed.loadFailed();
                        } else if (isLoading) {
                            System.out.println("执行失败");
                            mLoadingDialog.loadRequestFailed();
                        }
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (mGson == null) mGson = new Gson();
                        T dataType = null;
                        try {
                            dataType = mGson.fromJson(response.body(), clazz);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e(ConstantNet.JSONEXCEPTION, e.getMessage());
                            if (isJsonException) {
                                if (mLoadingDialog != null) {
                                    mLoadingDialog.loadJsonFailed();
                                }
                            }
                        } finally {
                            printJson(response.body());
                        }
                        //解析成功
                        if (dataType != null) {
                            if (isLoading) {
                                mLoadingDialog.loadSuccess();
                            }
                            //返回全部数据
//                            mRequestSuccess.needResultCode(dataType);
                            if (dataType.getCode() == ConstantNet.RESPONCE_CODE_INVALID) {
                                //当返回码为多少时，账号失效，此时需要用户重新登陆，清空用户信息
                            } else if (dataType.getCode() == ConstantNet.RESPONCE_CODE_SERVICE) {
                                //服务其错误
                            } else {
                                //返回用户数据
                                mRequestSuccess.needResultCode(dataType);
                            }
                        } else {//解析失败
                            if (isJsonException) {
                                if (mLoadingDialog != null) {
                                    mLoadingFailed.loadFailed();
//                                    mLoadingDialog.loadJsonFailed();
                                }
                            }
                        }
                    }
                });
    }


    /**
     * 返回数据
     *
     * @param <Y>
     */
    public interface NetRequestSuccess<Y extends BaseBean> {
        /**
         * 需要结果码
         *
         * @param y
         */
        void needResultCode(Y y);
    }

    /**
     * 加载失败，包括数据解析，网络请求，服务器等错误
     */
    public interface LoadingFailed {

        void loadFailed();
    }


    public interface NetRequestData<T> {
        /**
         * 需要结果码
         *
         * @param y
         */
        void noNeedResultCode(T y);
    }

    /**
     * 打印URL
     */
    private void printURL() {
        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        if (httpParams == null) {
            System.out.println("执行到此处1");
            Log.i(ConstantNet.LOG_URL, URL);
        } else {
            Set<String> keySet = httpParams.keySet();
            for (String key : keySet) {
                if (isFirst) {
                    sb.append("?" + key + "=" + httpParams.get(key));
                    isFirst = false;
                } else {
                    sb.append("&" + key + "=" + httpParams.get(key));
                }
            }
            Log.i(ConstantNet.LOG_URL, URL + sb.toString());
        }
    }

    /**
     * 打印输出内容
     *
     * @param json
     */
    private void printJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            Log.i(ConstantNet.LOG_JSON, jsonObject.toString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
