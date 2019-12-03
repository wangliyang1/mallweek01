package com.bawei.wangliyang.view.fragment;

import android.view.View;
import android.widget.TextView;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.base.BaseFragment;

public class OtherFragment extends BaseFragment {

    private TextView view;

    @Override
    protected void initData() {
        String key = getArguments().getString("key");
        view.setText(key);
    }

    @Override
    protected void initView(View inflate) {
        view = inflate.findViewById(R.id.view);
    }

    @Override
    protected int layoutId() {
        return R.layout.other;
    }
}
