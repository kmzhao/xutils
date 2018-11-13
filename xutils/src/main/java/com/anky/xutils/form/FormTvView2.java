package com.anky.xutils.form;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anky.xutils.R;


/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class FormTvView2 extends LinearLayout {
    private TextView tv_must;

    private TextView tv_name;

    private TextView tv_content;
    public String value;
    private RelativeLayout rl_tv;
    private Button btn_clear;

    public FormTvView2(Context context) {
        this(context, null);
    }

    public FormTvView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FormTvView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_form_tv2, this);
        tv_must = findViewById(R.id.tv_must);
        tv_content = findViewById(R.id.tv_content);
        tv_name = findViewById(R.id.tv_name);
        rl_tv = findViewById(R.id.rl_tv);
        btn_clear = findViewById(R.id.btn_clear);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FormTvAttr, defStyleAttr, 0);
        if (a != null) {
            String title = a.getString(R.styleable.FormTvAttr_ftvtitle);
            String content = a.getString(R.styleable.FormTvAttr_ftvcontent);
            String hint = a.getString(R.styleable.FormTvAttr_ftvhint);
            boolean must = a.getBoolean(R.styleable.FormTvAttr_ftvmust, true);
            boolean clear = a.getBoolean(R.styleable.FormTvAttr_ftvclear, true);
            a.recycle();
            tv_must.setVisibility(must ? View.VISIBLE : View.INVISIBLE);
            tv_content.setText(content == null ? "" : content);
            tv_content.setHint(hint == null ? "" : hint);
            tv_name.setText(title == null ? "" : handleTitle(title));
            btn_clear.setVisibility(clear ? VISIBLE : INVISIBLE);
        }
        btn_clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_content.setText("");
                value = "";
            }
        });
    }

    private String handleTitle(String title) {
        StringBuilder builder = new StringBuilder();
        if (title.length() <= 4) {
            for (int i = 0; i < 4 - title.length(); i++) {
                builder.append(" ");
            }
            builder.append(title);
            return builder.toString();
        }
        for (int i = 0; i < title.length(); i++) {
            builder.append(title.charAt(i));
            if (i == 3) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public void setContent(String content) {
        if (content == null) content = "";
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
        tv_name.setText(title == null ? "" : handleTitle(title));
    }

    public void setMust(boolean must) {
        tv_must.setVisibility(must ? View.VISIBLE : View.INVISIBLE);
    }
}
