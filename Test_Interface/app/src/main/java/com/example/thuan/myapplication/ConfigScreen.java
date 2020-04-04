package com.example.thuan.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class ConfigScreen extends Activity {

    private ImageView img,img2;
    private ViewGroup rootLayout,direction_a,direction_b,move,viewselect,viewstart;
    private int xDelta,yDelta ;
    DisplayMetrics displayMetrics;
    int screenHeight,screenWidth;
    private Button button_a,button_b,button_x,button_y,left,right,top,bottom,select,start,choose,save;
    private Data mDB;
    private ArrayList<Buton>btns=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen_interface);

        rootLayout =(ViewGroup) findViewById(R.id.viewgroup);
        viewselect =(ViewGroup) findViewById(R.id.viewselect);
        viewstart=(ViewGroup)findViewById(R.id.viewstart);
        img =(ImageView)findViewById(R.id.imageview);
        img2=(ImageView)findViewById(R.id.imageview2);
        direction_a=(ViewGroup)findViewById(R.id.direction_a);
        direction_b=(ViewGroup)findViewById(R.id.direction_b);
        move=(ViewGroup)findViewById(R.id.move);
        button_a=(Button)findViewById(R.id.button_a);
        button_b=(Button)findViewById(R.id.button_b);
        button_x=(Button)findViewById(R.id.button_x);
        button_y=(Button)findViewById(R.id.button_y);
        left=(Button)findViewById(R.id.left);
        start=(Button)findViewById(R.id.start);
        select=(Button)findViewById(R.id.select);
        choose=(Button)findViewById(R.id.choose);
        right=(Button)findViewById(R.id.right);
        top=(Button)findViewById(R.id.top);
        bottom=(Button)findViewById(R.id.bottom);
        save=(Button)findViewById(R.id.save);
        mDB = new Data(getApplicationContext());
        //mDB.onUpgrade(mDB.getWritableDatabase(),1,2);

        btns = mDB.getData();

        //Kich thuoc man hinh
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;

        RelativeLayout.LayoutParams layoutParamMove =new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        //int x=screenHeight/2-280;
        //int y=screenWidth/16;
        int x=btns.get(1).getX();
        int y=btns.get(1).getY();
        layoutParamMove.setMargins(y,x,0,0);
        move.setLayoutParams(layoutParamMove);
        move.setOnTouchListener(new ChoiceTouchListener());

        RelativeLayout.LayoutParams layoutParamSelect =new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
       // x=screenHeight/8;
       // y=screenWidth/2-400;
          x=btns.get(2).getX();
          y=btns.get(2).getY();
        layoutParamSelect.setMargins(y,x,0,0);
        viewselect.setLayoutParams(layoutParamSelect);
        viewselect.setOnTouchListener(new ChoiceTouchListener());

        RelativeLayout.LayoutParams layoutParamStart =new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        x=screenHeight/8;
//        y=screenWidth/2+160;
        x=btns.get(0).getX();
        y=btns.get(0).getY();
        layoutParamStart.setMargins(y,x,0,0);
        viewstart.setLayoutParams(layoutParamStart);
        viewstart.setOnTouchListener(new ChoiceTouchListener());

        RelativeLayout.LayoutParams layoutParamDirection_A =new RelativeLayout.LayoutParams(200,200);
//        x=screenHeight-450;
//        y=screenWidth/2-350;
        x=btns.get(3).getX();
        y=btns.get(3).getY();
        layoutParamDirection_A.setMargins(y,x,0,0);
        direction_a.setLayoutParams(layoutParamDirection_A);
        direction_a.setOnTouchListener(new ChoiceTouchListener());

        RelativeLayout.LayoutParams layoutParamDirection_B =new RelativeLayout.LayoutParams(200,200);
//        x=screenHeight-450;
//        y=screenWidth/2+160;
        x=btns.get(4).getX();
        y=btns.get(4).getY();
        layoutParamDirection_B.setMargins(y,x,0,0);
        direction_b.setLayoutParams(layoutParamDirection_B);
        direction_b.setOnTouchListener(new ChoiceTouchListener());


        RelativeLayout.LayoutParams layoutParams =new RelativeLayout.LayoutParams(100,100);
        layoutParams.setMargins(50,50,0,0);
        img.setLayoutParams(layoutParams);
        img.setOnTouchListener(new ChoiceTouchListener());

        RelativeLayout.LayoutParams layoutParam2 =new RelativeLayout.LayoutParams(100,100);
        layoutParam2.setMargins(50,50,0,0);
        img2.setLayoutParams(layoutParam2);
        img2.setOnTouchListener(new ChoiceTouchListener());


        RelativeLayout.LayoutParams layoutParamButtonX =(RelativeLayout.LayoutParams)button_x.getLayoutParams();
//        x=screenHeight/2+30;
//        y=screenWidth-screenWidth/4+105;
        x=btns.get(5).getX();
        y=btns.get(5).getY();
        layoutParamButtonX.setMargins(y,x,0,0);
        button_x.setLayoutParams(layoutParamButtonX);
        button_x.setOnTouchListener(new ChoiceTouchListener());

        RelativeLayout.LayoutParams layoutParamButtonY =(RelativeLayout.LayoutParams)button_y.getLayoutParams();
//        x=screenHeight/2-270;
//        y=screenWidth-screenWidth/4+105;
        x=btns.get(6).getX();
        y=btns.get(6).getY();
        layoutParamButtonY.setMargins(y,x,0,0);
        button_y.setLayoutParams(layoutParamButtonY);
        button_y.setOnTouchListener(new ChoiceTouchListener());

        RelativeLayout.LayoutParams layoutParamButtonA =(RelativeLayout.LayoutParams)button_a.getLayoutParams();
//        x=screenHeight/2-120;
//        y=screenWidth-screenWidth/4-50;
        x=btns.get(7).getX();
        y=btns.get(7).getY();
        layoutParamButtonA.setMargins(y,x,0,0);
        button_a.setLayoutParams(layoutParamButtonA);
        button_a.setOnTouchListener(new ChoiceTouchListener());

        final RelativeLayout.LayoutParams layoutParamButtonB =(RelativeLayout.LayoutParams)button_b.getLayoutParams();
//        x=screenHeight/2-120;
//        y=screenWidth-screenWidth/8;
        x=btns.get(8).getX();
        y=btns.get(8).getY();
        layoutParamButtonB.setMargins(y,x,0,0);
        button_b.setLayoutParams(layoutParamButtonB);
        button_b.setOnTouchListener(new ChoiceTouchListener());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout.LayoutParams layoutParamButtonb =(RelativeLayout.LayoutParams)button_b.getLayoutParams();
                int x=layoutParamButtonb.topMargin;
                int y=layoutParamButtonb.leftMargin;
                Log.d("ttttt",x+" "+y);
                Buton btn =new Buton(9,x,y);
                mDB.Update(btn);
            }
        });

    }

    private final class ChoiceTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int x =(int)motionEvent.getRawX();
            int y=(int)motionEvent.getRawY();
            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK)
            {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)view.getLayoutParams();
                    xDelta=x-lParams.leftMargin;
                    yDelta=y-lParams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams lParames = (RelativeLayout.LayoutParams)view.getLayoutParams();
                    lParames.leftMargin=x-xDelta;
                    lParames.topMargin=y-yDelta;
                    lParames.rightMargin=-250;
                    lParames.bottomMargin=-250;
                   // Log.i("ttttttt",lParames.leftMargin+","+lParames.topMargin);
                    if(view.getId()==R.id.imageview||view.getId()==R.id.imageview2)
                    {
                        if(lParames.leftMargin<=-40||lParames.topMargin<=-40||lParames.leftMargin>=190||lParames.topMargin>=190)
                        {
                            lParames.setMargins(50,50,0,0);
                        }
                    }
                    view.setLayoutParams(lParames);

                    break;
            }
            switch (view.getId())
            {
                case R.id.imageview:
                    direction_a.invalidate();
                    break;
                case R.id.imageview2:
                    direction_b.invalidate();
                    break;
                default:
                    rootLayout.invalidate();
                    break;
            }

            return true;
        }
    }
}
