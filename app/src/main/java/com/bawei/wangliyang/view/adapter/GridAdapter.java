package com.bawei.wangliyang.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangliyang.R;
import com.bawei.wangliyang.contract.bean.Layyer;
import com.bawei.wangliyang.util.NetUtil;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    List<Layyer.ShopGridDataBean> shopGridData;
    public GridAdapter(List<Layyer.ShopGridDataBean> shopGridData) {
        this.shopGridData = shopGridData;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.child,null);
            viewHolder.imageView = convertView.findViewById(R.id.imageview);
            viewHolder.tv_one = convertView.findViewById(R.id.tv_one);
            viewHolder.tv_two = convertView.findViewById(R.id.tv_two);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Layyer.ShopGridDataBean shopGridDataBean = shopGridData.get(position);
        viewHolder.tv_one.setText(shopGridDataBean.getTitle());
        viewHolder.tv_two.setText(shopGridDataBean.getPrice());
        NetUtil.getInstance().getPhono(shopGridDataBean.getImageurl(),viewHolder.imageView);
        return convertView;
    }
    class ViewHolder{
        private ImageView imageView;
        private TextView tv_one;
        private TextView tv_two;
    }
}
