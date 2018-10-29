package com.anky.utils;

import android.content.Context;

import com.anky.xutils.recycler.CommonAdapter;
import com.anky.xutils.recycler.base.ViewHolder;

import java.util.List;

/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class MyAdapter extends CommonAdapter<String>{
    public MyAdapter(Context context, List<String> datas) {
        super(context, R.layout.adapter_common, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        holder.setText(R.id.tv_desc,s);
    }
}
