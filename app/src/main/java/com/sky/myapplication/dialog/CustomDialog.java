package com.sky.myapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.sky.myapplication.androidword1.R;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView layout_custom_dialog_text_title, layout_custom_dialog_text_content,
            layout_custom_dialog_linear_text_ok, layout_custom_dialog_linear_text_no;
    private String title, content, ok, no;
    private IOnNoListener iOnNoListener;
    private IOnOkListener iOnOkListener;

    public CustomDialog(Context context, String title, String content, String ok, String no, IOnNoListener iOnNoListener, IOnOkListener iOnOkListener) {
        super(context);
        this.title = title;
        this.content = content;
        this.ok = ok;
        this.no = no;
        this.iOnNoListener = iOnNoListener;
        this.iOnOkListener = iOnOkListener;

    }

    public CustomDialog(Context context, int themeResId, String title, String content, String ok, String no, IOnNoListener iOnNoListener, IOnOkListener iOnOkListener) {
        super(context, themeResId);
        this.title = title;
        this.content = content;
        this.ok = ok;
        this.no = no;
        this.iOnNoListener = iOnNoListener;
        this.iOnOkListener = iOnOkListener;
    }

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //设置宽度,部分机型以及安卓系统可能存在无法适应弹窗大小的问题
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        //设置当前弹窗的宽度为当前手机屏幕宽度的80%
        layoutParams.width = (int) (size.x * 0.8);
        getWindow().setAttributes(layoutParams);
        //如果你是圆角之类的话，这句设置背景透明要加上。
        //否则有个白底在那儿，你的dialog也是白色的话是看不到圆角的
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);


        layout_custom_dialog_text_title = findViewById(R.id.layout_custom_dialog_text_title);
        layout_custom_dialog_text_content = findViewById(R.id.layout_custom_dialog_text_content);
        layout_custom_dialog_linear_text_ok = findViewById(R.id.layout_custom_dialog_linear_text_ok);
        layout_custom_dialog_linear_text_no = findViewById(R.id.layout_custom_dialog_linear_text_no);

        if (TextUtils.isEmpty(title))
            layout_custom_dialog_text_title.setText(title);
        if (TextUtils.isEmpty(content))
            layout_custom_dialog_text_content.setText(content);
        if (TextUtils.isEmpty(ok))
            layout_custom_dialog_linear_text_ok.setText(ok);
        if (TextUtils.isEmpty(no))
            layout_custom_dialog_linear_text_no.setText(no);
        layout_custom_dialog_linear_text_ok.setOnClickListener(this);
        layout_custom_dialog_linear_text_no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_custom_dialog_linear_text_ok:
                if (iOnOkListener != null) {
                    iOnOkListener.onOk(this);
                }
                dismiss();
                break;
            case R.id.layout_custom_dialog_linear_text_no:
                if (iOnNoListener != null) {
                    iOnNoListener.onNo(this);
                }
                dismiss();
                break;
            default:
                break;
        }
    }

    public interface IOnOkListener {
        void onOk(CustomDialog dialog);
    }

    public interface IOnNoListener {
        void onNo(CustomDialog dialog);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getOk() {
        return ok;
    }

    public String getNo() {
        return no;
    }

    public IOnNoListener getiOnNoListener() {
        return iOnNoListener;
    }

    public IOnOkListener getiOnOkListener() {
        return iOnOkListener;
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setContent(String content) {
        this.content = content;
        return this;

    }

    public CustomDialog setOk(String ok, IOnOkListener iOnOkListener) {
        this.ok = ok;
        this.iOnOkListener = iOnOkListener;
        return this;

    }

    public CustomDialog setNo(String no, IOnNoListener iOnNoListener) {
        this.no = no;
        this.iOnNoListener = iOnNoListener;
        return this;

    }
}
