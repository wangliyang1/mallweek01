package com.bawei.wangliyang.model;

import com.bawei.wangliyang.contract.HomeContract;
import com.bawei.wangliyang.contract.bean.Layyer;
import com.bawei.wangliyang.util.NetUtil;
import com.google.gson.Gson;

public class ShopModel {
    public void onGetShop(final HomeContract.IPresenter iPresenter){
        NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.Callback() {
            @Override
            public void onGetJson(String s) {
                Layyer layyer = new Gson().fromJson(s, Layyer.class);
                iPresenter.getSuccess(layyer);
            }

            @Override
            public void onError(Throwable throwable) {
                iPresenter.getFailtre(throwable);
            }
        });
    }
}
