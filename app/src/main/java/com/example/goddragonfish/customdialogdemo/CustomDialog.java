package com.example.goddragonfish.customdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


/**
 * Created by GodDragonFish on 2017/12/23.
 */

public class CustomDialog extends Dialog{

    private static boolean flag=true;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }


    public static class Builder{
        private Context context;
        private CustomDialog dialog;
        private int style;
        private int position;
        private int width;
        private int height;
        private View customView;
        private int anim;

        public Builder setStyle(int style){
            this.style=style;
            return this;
        }

        public Builder(Context context){
            this.context=context;
        }

        public Builder setPosition(int position) {
            this.position = position;
            return this;
        }

        public Builder setWidthOrHeight(int width,int height) {
            this.width = width;
            this.height=height;
            return this;
        }

        public Builder setCustomView(View view){
            this.customView=view;
            return this;
        }

        public Builder setAnim(int anim){
            this.anim=anim;
            return this;
        }

        public Dialog create(){
            if(dialog==null){
                dialog=new CustomDialog(context,style);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setCancelable(true);
                dialog.show();
                Window window=dialog.getWindow();
                window.setGravity(position);
                window.setWindowAnimations(anim);
                WindowManager.LayoutParams params=window.getAttributes();
                //获取屏幕长宽
                //Point size=new Point();
                //window.getWindowManager().getDefaultDisplay().getSize(size);
                //params.width=getScreenWidth(context,width);
                params.width=dp2px(context,width);
                params.height=dp2px(context,height);
                window.setAttributes(params);
                dialog.setContentView(customView);
            }
            dialog.show();
            return dialog;
        }



        //公式：density=densityDpi/160，px=dp*density
        //根据自定义的高(dp)获取px单位的高
        //在java中，强制转换符把float转换为int时，是直接丢掉小数部分的，
        //加0.5f起到了四舍五入的作用，可以减小误差。
        public int dp2px(Context context,int dp){
            float density=context.getResources().getDisplayMetrics().density;
            return (int)(dp*density+0.5f);
        }


    }




}
