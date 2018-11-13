package com.anky.xutils.form;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anky.xutils.R;


/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class FormItView extends LinearLayout {
    private TextView tv_must;

    private TextView tv_name;

    private TextView tv_content;
    public String value="";

    public FormItView(Context context) {
        this(context, null);
    }

    public FormItView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FormItView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_form_it, this);
        tv_must = findViewById(R.id.tv_must);
        tv_content = findViewById(R.id.tv_content);
        tv_name = findViewById(R.id.tv_name);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FormItAttr, defStyleAttr, 0);
        if (a != null) {
            String title = a.getString(R.styleable.FormItAttr_fittitle);
            String content = a.getString(R.styleable.FormItAttr_fitcontent);
            String hint = a.getString(R.styleable.FormItAttr_fithint);
            boolean must = a.getBoolean(R.styleable.FormItAttr_fitmust, true);
            a.recycle();
            tv_must.setVisibility(must ? View.VISIBLE : View.GONE);
            tv_content.setText(content == null ? "" : content);
            tv_content.setHint(hint == null ? "" : hint);
            tv_name.setText(title == null ? "" : title);
        }
    }

    public void setContent(String content) {
        if (content == null) {
            content = "";
        }
        value=content;
        /***/
        if (tv_content != null)
            tv_content.setText(content);
    }

    public String getText() {
        if(tv_content==null) return "";
        return tv_content.getText().toString().trim();
    }

    public void setHintContent(String hint) {
        tv_content.setHint(hint == null ? "" : hint);    }

    public void setTitle(String title) {
        tv_name.setText(title == null ? "" : title);
    }

    public void setMust(boolean must) {
        tv_must.setVisibility(must ? View.VISIBLE : View.GONE);

    }
}
