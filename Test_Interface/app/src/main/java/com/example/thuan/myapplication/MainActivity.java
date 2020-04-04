package com.example.thuan.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends Activity {


    private Button button_a,button_b;
    EditText ipadd;
    String ip="";
    int port=8000;
    Boolean kt;
    public static Socket s;
    private static PrintWriter printWriter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kt=false;
        button_a=(Button)findViewById(R.id.config);
        button_b=(Button)findViewById(R.id.connect);
        ipadd =(EditText)findViewById(R.id.ipadd);



        button_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ip=ipadd.getText().toString();
                Thread mt=new Thread(new myTask());
               mt.start();
            }
        });


        button_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Test.class);
                startActivity(intent);
                finish();
            }
        });
    }

    class myTask implements Runnable {
        @Override
        public void run() {
            try {
                String mess = "Connect to Server";
                SocketHandler.setSocket(new Socket(ip,port));
                //s=SocketHandler.getSocket();
                printWriter = new PrintWriter(SocketHandler.getSocket().getOutputStream());
                printWriter.write(mess);

                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(),"Connect Success!",Toast.LENGTH_SHORT).show();
                        startActivity(ConnectPC.getIntent(MainActivity.this));
                        //finish();
                    }
                });
                printWriter.flush();
               // printWriter.close();
                //s.close();
            }
            catch (ConnectException e)
            {
                runOnUiThread(new Runnable() {

                    public void run() {

                        Toast.makeText(MainActivity.this,"Khong co ket noi!\n Moi thu lai",Toast.LENGTH_SHORT).show();
                    }
                });
            }
            catch (IOException e) {
                e.printStackTrace();
                //  return null;
            }
        }
    }


}
