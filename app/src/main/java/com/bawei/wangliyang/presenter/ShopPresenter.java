package com.bawei.wangliyang.presenter;

import com.bawei.wangliyang.contract.HomeContract;
import com.bawei.wangliyang.contract.bean.Layyer;
import com.bawei.wangliyang.model.ShopModel;

public class ShopPresenter {
    public void onGetShop(final HomeContract.IView iView){
        ShopModel shopModel = new ShopModel();
        shopModel.onGetShop(new HomeContract.IPresenter() {
            @Override
            public void getSuccess(Layyer layyer) {
                iView.getSuccess(layyer);
            }

            @Override
            public void getFailtre(Throwable throwable) {
                iView.getFailtre(throwable);
            }
        });
    }
}
