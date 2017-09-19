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

    private LoadingFaild mLoadingFaild;


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


    public BasePresenter setLoadingFaild(LoadingFaild loadingFaild) {
        mLoadingFaild = loadingFaild;
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
                .setFirstLoading(false)
                .requestCodeSuccess(new BaseRequest.NetRequestSuccess<B>() {
                    @Override
                    public void needResultCode(B commonBean) {
                        mSuccessResponse.success(commonBean);
                    }
                })
                .setLoadingFailed(new BaseRequest.LoadingFailed() {
                    @Override
                    public void loadFailed() {
                        mLoadingFaild.loadFailed();
                    }
                })
                .netGetRequest();

    }


    public interface SuccessResponse<B extends BaseBean> {
        void success(B b);
    }


    /**
     * 加载失败，包括网络请求
     */
    public interface LoadingFaild{
        void loadFailed();
    }

}
