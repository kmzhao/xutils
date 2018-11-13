package com.anky.utils;

import android.content.Context;
import android.view.View;

import com.anky.xutils.recycler.CommonAdapter;
import com.anky.xutils.recycler.base.ViewHolder;
import com.anky.xutils.swipelayout.XMenuLayout;

import java.util.List;

/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class MyAdapter extends CommonAdapter<String> {
    public MyAdapter(Context context, List<String> datas) {
        super(context, R.layout.adapter_common, datas);
    }

    @Override
    protected void convert(final ViewHolder holder, String s, int position) {
        holder.setText(R.id.tv_desc, s);
        holder.setOnClickListener(R.id.btnTop, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = holder.getView(R.id.xmenu);
                ((XMenuLayout) view).smoothClose();
            }
        });
    }
}
