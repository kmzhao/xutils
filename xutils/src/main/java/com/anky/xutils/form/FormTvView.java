package com.anky.xutils.form;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anky.xutils.R;


/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class FormTvView extends LinearLayout {
    private TextView tv_must;

    private TextView tv_name;

    private TextView tv_content;
    public String value;
    private RelativeLayout rl_tv;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public FormTvView(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public FormTvView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public FormTvView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_form_tv, this);
        tv_must = findViewById(R.id.tv_must);
        tv_content = findViewById(R.id.tv_content);
        tv_name = findViewById(R.id.tv_name);
        rl_tv = findViewById(R.id.rl_tv);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FormTvAttr, defStyleAttr, 0);
        if (a != null) {
            String title = a.getString(R.styleable.FormTvAttr_ftvtitle);
            String content = a.getString(R.styleable.FormTvAttr_ftvcontent);
            String hint = a.getString(R.styleable.FormTvAttr_ftvhint);
            boolean must = a.getBoolean(R.styleable.FormTvAttr_ftvmust, true);
            Drawable drawable = a.getDrawable(R.styleable.FormTvAttr_ftvcolor);
            a.recycle();
            tv_must.setVisibility(must ? View.VISIBLE : View.GONE);
            tv_content.setText(content == null ? "" : content);
            tv_content.setHint(hint == null ? "" : hint);
            tv_name.setText(title == null ? "" : title);
            if (drawable != null)
                tv_content.setBackground(drawable);
        }
    }

    public void setContent(String content) {
        tv_content.setText(content);
        value = content;
    }

    public void setListener(OnClickListener listener) {
        rl_tv.setOnClickListener(listener);
    }

    public void setHintContent(String content) {
        tv_content.setHint(content);
    }

    public void setTitle(String title) {
        tv_name.setText(title);
    }

    public void setMust(boolean must) {
        tv_must.setVisibility(must ? View.VISIBLE : View.GONE);
    }
}
