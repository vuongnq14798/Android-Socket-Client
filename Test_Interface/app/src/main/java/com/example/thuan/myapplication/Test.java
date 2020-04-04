package com.example.thuan.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Test extends Activity implements View.OnClickListener{
    private ViewGroup rootLayout;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        rootLayout=(ViewGroup)findViewById(R.id.viewgroup);
        //added the textView and the Button to LinearLayout
       // rootLayout.addView(textView);
        View itemView = View.inflate(getApplicationContext(), R.layout.move_direction, rootLayout);

        Button button_top=(Button) itemView.findViewById(R.id.top);
        Button button_down=(Button) itemView.findViewById(R.id.bottom);
        Button button_right=(Button) itemView.findViewById(R.id.right);
        Button button_left=(Button) itemView.findViewById(R.id.left);

        button_top.setOnClickListener(this);
        button_down.setOnClickListener(this);
        button_right.setOnClickListener(this);
        button_left.setOnClickListener(this);


       // rootLayout.addView(add());
    }

//    @SuppressLint("ResourceType")
//    private View add()
//    {
////        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
////        LinearLayout linearLayout =new LinearLayout(this);
////        linearLayout.setOrientation(LinearLayout.VERTICAL);
////        Button button = new Button(this);
////        button.setText("top");
////        button.setId(1);
////        // button.setGravity(Gravity.CENTER_VERTICAL);
////        button.setLayoutParams(lp);
////        linearLayout.addView(button);
////        LinearLayout linearLayout1 =new LinearLayout(this);
////        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
////        Button button1 = new Button(this);
////        button1.setText("left");
////        button1.setId(2);
////        linearLayout1.addView(button1);
////        Button button2 = new Button(this);
////        button2.setText("right");
////        button2.setId(3);
////        linearLayout1.addView(button2);
////        linearLayout1.setLayoutParams(lp);
////        linearLayout.addView(linearLayout1);
////        Button button3 = new Button(this);
////        button3.setText("down");
////        //button3.setGravity(Gravity.CENTER_HORIZONTAL);
////        button3.setLayoutParams(lp);
////        button3.setId(4);
////        // button3.setLayoutParams(params);
////        linearLayout.addView(button3);
////        return linearLayout;
//        //View itemView = View.inflate(getApplicationContext(), R.layout.move_direction, rootLayout);
//        //return itemView;
//    }

    @Override
    public void onClick(View view) {
        String messeage="";
        switch (view.getId()) {
            case R.id.top: messeage="len";break;
            case R.id.bottom: messeage="xuong";break;
            case R.id.right: messeage="phai";break;
            case R.id.left: messeage="trai";break;
        }
        Toast.makeText(getApplicationContext(),messeage,Toast.LENGTH_SHORT).show();
    }
}
