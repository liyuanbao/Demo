package dfy.networklibrary.base;

import com.lzy.okgo.model.HttpParams;

import java.util.HashMap;

import dfy.networklibrary.net.BaseBean;
import dfy.networklibrary.net.BaseRequest;

/**
 * Created by Admin on 2017/8/31.
 */

public class BasePresenter<T extends BaseView, B extends BaseBean> {

    public T getInterfaceUI;

    public Class<B> clazz;

    private String URL;


    private HashMap<String, String> mHashMap;

    private SuccessResponse mSuccessResponse;

    public BasePresenter<T, B> setSuccessResponse(SuccessResponse successResponse) {
        mSuccessResponse = successResponse;
        return this;
    }

    public BasePresenter setHashMap(HashMap<String, String> hashMap) {
        mHashMap = hashMap;
        return this;
    }

    public BasePresenter setURL(String URL) {
        this.URL=URL;
        return this;
    }


    public BasePresenter setClazz(Class<B> clazz) {
        this.clazz = clazz;
        return this;
    }

    /**
     * 网络请求二次封装
     *
     */
    public void CommonNetRequest() {
        new BaseRequest<B>()
                .setURL(URL)
                .addHttpParams(mHashMap)
                .setDataType(clazz)
                .setIsLoading(true)
                .requestCodeSuccess(new BaseRequest.NetRequestSuccess<B>() {
                    @Override
                    public void needResultCode(B commonBean) {
//                        getInterfaceUI.entryItem(commonBean);
                        mSuccessResponse.success(commonBean);
                    }
                })
                .netGetRequest();

    }


    public interface SuccessResponse<B extends BaseBean> {
        void success(B b);
    }


}
