package com.bawei.wangliyang.contract;

import com.bawei.wangliyang.contract.bean.Layyer;

public interface HomeContract {
    public interface IPresenter{
        void getSuccess(Layyer layyer);
        void getFailtre(Throwable throwable);
    }
    public interface IView{
        void getSuccess(Layyer layyer);
        void getFailtre(Throwable throwable);
    }
}
