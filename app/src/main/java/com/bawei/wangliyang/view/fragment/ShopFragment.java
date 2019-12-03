package com.bawei.wangliyang.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BaseFragment;
import com.bawei.wangliyang.contract.HomeContract;
import com.bawei.wangliyang.contract.bean.Layyer;
import com.bawei.wangliyang.presenter.ShopPresenter;
import com.bawei.wangliyang.view.activity.MainActivity;
import com.bawei.wangliyang.view.adapter.GridAdapter;

import java.util.List;

public class ShopFragment extends BaseFragment {

    private Button button;
    private GridView gv;

    @Override
    protected void initData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.getHome();
            }
        });

        ShopPresenter shopPresenter = new ShopPresenter();
        shopPresenter.onGetShop(new HomeContract.IView() {
            @Override
            public void getSuccess(Layyer layyer) {
                List<Layyer.ShopGridDataBean> shopGridData = layyer.getShopGridData();
                gv.setAdapter(new GridAdapter(shopGridData));
            }

            @Override
            public void getFailtre(Throwable throwable) {

            }
        });

    }

    @Override
    protected void initView(View inflate) {
        button = inflate.findViewById(R.id.button);
        gv = inflate.findViewById(R.id.gv);
    }

    @Override
    protected int layoutId() {
        return R.layout.shop;
    }
}
