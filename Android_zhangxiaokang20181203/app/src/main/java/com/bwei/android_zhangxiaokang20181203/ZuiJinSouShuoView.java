package com.bwei.android_zhangxiaokang20181203;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ZuiJinSouShuoView extends FrameLayout {

    private TextView textView;
    private LayoutParams params;
    private final static int H_DISTANCE=20;//宽
    private final static int V_DISTANCE=20;//高
    private View view;

    public ZuiJinSouShuoView(Context context) {
        super(context);
    }

    public ZuiJinSouShuoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZuiJinSouShuoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addTextView(String keys) {
        MyHelper helper=new MyHelper(getContext());
        SQLiteDatabase database = helper.getWritableDatabase();
        database.execSQL("insert into user(title) values(?)",new String[]{keys});
        textView = (TextView) View.inflate(getContext(), R.layout.soushuo_layout, null);
        textView.setText(keys);
        params = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);
        addView(textView);

        Toast.makeText(getContext(),textView.getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //获取本控件的宽度
        int width = getWidth();
        //行数
        int row=0;
        //本控件左边的
        int disWidth = H_DISTANCE;
        for (int i = 0; i <getChildCount() ; i++) {
            view = getChildAt(i);
            int viewWidth = view.getWidth();
            int viewHeight = view.getHeight();
            if (disWidth+viewWidth>width){
                row++;
                disWidth=H_DISTANCE;
            }
            int viewtop = row * viewHeight + row * V_DISTANCE;
            view.layout(disWidth,viewtop,disWidth+viewWidth,viewtop+viewHeight);
            disWidth+=(viewWidth+H_DISTANCE);
        }


    }
}
