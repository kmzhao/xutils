package com.anky.xutils.form;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anky.xutils.R;


/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class FormEtView extends LinearLayout {

    private TextView tv_must;

    private TextView tv_name;

    private EditText et_content;
    public String value;

    public FormEtView(Context context) {
        this(context, null);
    }

    public FormEtView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FormEtView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_form_et, this);
        tv_must = findViewById(R.id.tv_must);
        et_content = findViewById(R.id.et_content);
        tv_name = findViewById(R.id.tv_name);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FormEtAttr, defStyleAttr, 0);
        if (a != null) {
            String title = a.getString(R.styleable.FormEtAttr_fettitle);
            String content = a.getString(R.styleable.FormEtAttr_fetcontent);
            String hint = a.getString(R.styleable.FormEtAttr_fethint);
            boolean must = a.getBoolean(R.styleable.FormEtAttr_fetmust, true);
            a.recycle();
            tv_must.setVisibility(must ? View.VISIBLE : View.GONE);
            et_content.setText(content == null ? "" : content);
            et_content.setHint(hint == null ? "" : hint);
            tv_name.setText(title == null ? "" : title);
        }
    }

    public String getText() {
        if (et_content == null) return "";
        String trim = et_content.getText().toString().replaceAll("\\s*", "");
        value = trim;
        return trim;
    }

    public void setHintContent(String hint) {
        et_content.setHint(hint == null ? "" : hint);
    }

    public void setTitle(String title) {
        tv_name.setText(title == null ? "" : title);
    }

    public void setMust(boolean must) {
        tv_must.setVisibility(must ? View.VISIBLE : View.GONE);
    }

    public void setContent(String content) {
        et_content.setText(content == null ? "" : content);
        value = content;
    }

    public void setInputType(int type) {
        et_content.setInputType(type);
    }
}
