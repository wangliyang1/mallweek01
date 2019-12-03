package com.bawei.wangliyang.view.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BaseFragment;
import com.bawei.wangliyang.util.NetUtil;

public class HomeFragment extends BaseFragment {

    private TextView tv;
    private RelativeLayout rel;

    @Override
    protected void initData() {
        if (NetUtil.getInstance().isWang(getContext())){
            tv.setVisibility(View.VISIBLE);
            rel.setVisibility(View.GONE);
        }else {
            tv.setVisibility(View.GONE);
            rel.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initView(View inflate) {
        tv = inflate.findViewById(R.id.tv);
        rel = inflate.findViewById(R.id.rel);
    }

    @Override
    protected int layoutId() {
        return R.layout.home;
    }
}
