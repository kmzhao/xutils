package com.anky.xutils.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anky.xutils.R;


/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class TitleView extends RelativeLayout {
    private RelativeLayout rl_back;
    private RelativeLayout rl_more;
    private TextView tv_title;
    private TextView tv_more;
    private TextView tv_confirm;
    private Context mContext;

    public TitleView(Context context) {
        this(context, null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        LayoutInflater.from(context).inflate(R.layout.view_title, this);
        rl_back = findViewById(R.id.rl_back);
        rl_more = findViewById(R.id.rl_more);
        tv_title = findViewById(R.id.tv_title);
        tv_more = findViewById(R.id.tv_more);
        tv_confirm=findViewById(R.id.tv_confirm);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TitleViewAttr, defStyleAttr, 0);
        if(a!=null){
            String text = a.getString(R.styleable.TitleViewAttr_title_titleText);
            String more = a.getString(R.styleable.TitleViewAttr_title_titleMore);
            String confirm=a.getString(R.styleable.TitleViewAttr_title_confirmText);
            boolean isBack = a.getBoolean(R.styleable.TitleViewAttr_title_backVisible, false);
            boolean isMore = a.getBoolean(R.styleable.TitleViewAttr_title_moreVisible, false);
            boolean isConfirm=a.getBoolean(R.styleable.TitleViewAttr_title_confirmVisible,false);
            a.recycle();
            rl_back.setVisibility(isBack? View.VISIBLE:View.GONE);
            tv_more.setVisibility(isMore?View.VISIBLE:GONE);
            tv_confirm.setVisibility(isConfirm?View.VISIBLE:GONE);
            tv_title.setText(text==null?"":text);
            tv_more.setText(more==null?"":more);
            tv_confirm.setText(confirm==null?"确定":confirm);
        }

        rl_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)mContext).finish();
                if(mBackListener!=null){
                    mBackListener.doSthForBack();
                }
            }
        });
    }

    public interface OnBackListener{
        void doSthForBack();
    }
    private OnBackListener mBackListener;

    public void setOnBack(OnBackListener listener) {
        this.mBackListener=listener;
    }

    public void setOnBackListener(OnClickListener listener) {
        if (listener == null) throw new IllegalArgumentException("listener params can't be null");
        rl_back.setOnClickListener(listener);
    }

    public void setOnMoreListener(OnClickListener listener) {
        if (listener == null) throw new IllegalArgumentException("listener params can't be null");
        rl_more.setOnClickListener(listener);
    }

    public void setTitle(String text) {
        if (text == null) throw new IllegalArgumentException("text params can't be null");
        tv_title.setText(text);
    }

    public void setMore(String text) {
        if (text == null) throw new IllegalArgumentException("text params can't be null");
        tv_more.setText(text);
    }

    public void showBack() {
        rl_back.setVisibility(VISIBLE);
    }

    public void hideBack() {
        rl_back.setVisibility(GONE);
    }

    public void showMore(){rl_more.setVisibility(VISIBLE);}

    public void hideMore(){rl_more.setVisibility(GONE);}

}
