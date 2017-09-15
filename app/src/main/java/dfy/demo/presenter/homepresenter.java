package dfy.demo.presenter;

import java.util.HashMap;
import java.util.List;

import dfy.demo.bean.HomeBean;
import dfy.networklibrary.base.BasePresenter;
import dfy.demo.bean.DetailBean;
import dfy.networklibrary.base.BaseView;
import dfy.networklibrary.net.BaseBean;
import dfy.networklibrary.net.BaseRequest;
import dfy.networklibrary.net.ConstantNet;

/**
 * Created by Admin on 2017/8/31.
 */

public class homepresenter<H extends BaseView, D extends BaseBean> extends BasePresenter<HomeView,BaseBean> {

    public homepresenter(HomeView view){
        getInterfaceUI=view;
    }

    public void homeIndex(){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("page","1");
        hashMap.put("areaId","");
        hashMap.put("dataId","");
        hashMap.put("year","");

        new BaseRequest<DetailBean>()
                .setURL(ConstantNet.LAW_DETAIL)
                .addHttpParams(hashMap)
                .setDataType(DetailBean.class)
                .setIsLoading(false)
                .setIsJsonException(true)
                .setLoadingFailed(new BaseRequest.LoadingFailed() {
                    @Override
                    public void loadFailed() {
                        getInterfaceUI.fail();
                    }
                })
                .requestCodeSuccess(new BaseRequest.NetRequestSuccess<DetailBean>() {
                    @Override
                    public void needResultCode(DetailBean baseBean) {
                        getInterfaceUI.getIndex(baseBean);
                    }
                })
                .netGetRequest();
    }
}
