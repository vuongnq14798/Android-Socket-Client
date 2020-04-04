package com.example.thuan.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;

import static java.lang.System.out;


public class ConnectPC extends Activity implements View.OnClickListener {

    private Button button_a,button_b,button_x,button_y,button_top,button_bottom,button_left,button_right,button_enter,button_space,button_tab;
    private TextView stream;
    boolean ISStream;

    private static Socket socket;
    private static PrintWriter printWriter;

    String messeage ="";
    private static String ip ="";
    private static int port =8000;
    myTask mt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_conect_interface);
        button_a=(Button)findViewById(R.id.button_a);
        button_b=(Button)findViewById(R.id.button_b);
        button_x=(Button)findViewById(R.id.button_x);
        button_y=(Button)findViewById(R.id.button_y);
        button_top=(Button)findViewById(R.id.top);
        button_left=(Button)findViewById(R.id.left);
        button_bottom=(Button)findViewById(R.id.bottom);
        button_right=(Button)findViewById(R.id.right);
        button_enter=(Button)findViewById(R.id.enter);
        button_tab=(Button)findViewById(R.id.tab);
        button_space=(Button)findViewById(R.id.space);
        ISStream=false;
        stream=(TextView)findViewById(R.id.stream);
        //new Thread(new ClientThread()).start();
       // text =(EditText)findViewById(R.id.txt);
        //text.setOnEditorActionListener(editorListener);
        Bundle extras = getIntent().getExtras();
        socket = SocketHandler.getSocket();
        try {
            socket.connect(socket.getLocalSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("Vuong", socket.toString());
        stream.setOnClickListener(this);
        button_a.setOnClickListener(this);
        button_b.setOnClickListener(this);
        button_x.setOnClickListener(this);
        button_y.setOnClickListener(this);
        button_top.setOnClickListener(this);
        button_left.setOnClickListener(this);
        button_right.setOnClickListener(this);
        button_space.setOnClickListener(this);
        button_bottom.setOnClickListener(this);
        button_enter.setOnClickListener(this);
        button_tab.setOnClickListener(this);


       // mt =new myTask();
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.stream)
        {
            if(!ISStream) {
                Toast.makeText(getApplicationContext(), "Show Stream!", Toast.LENGTH_SHORT).show();
                stream.setText("OFFSTREAM");
                ISStream=true;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "STOP Stream!", Toast.LENGTH_SHORT).show();
                stream.setText("ONSTREAM");
                ISStream=false;
            }
        }
        else {
            Check(view);
        }
    }

    public void Check(View view)
    {
        switch (view.getId()) {
            case R.id.button_a: messeage="2 4096 0 0 0 0 0 0\0";break;
            case R.id.button_b: messeage="b";break;
            case R.id.button_x: messeage="x";break;
            case R.id.button_y: messeage="y";break;
            case R.id.top: messeage="top";break;
            case R.id.bottom: messeage="down";break;
            case R.id.left: messeage="left";break;
            case R.id.right: messeage="right";break;
            case R.id.enter: messeage="enter";break;
            case R.id.space: messeage="space";break;
            case R.id.tab: messeage="tab";break;
        }

        mt=new myTask();
        mt.execute(messeage);

    }

     class myTask extends AsyncTask<String,Void,Void>{
        @Override
        protected Void doInBackground(String... voids) {

            try {
                String mess = voids[0];
                //s = new Socket(ip, port);
                printWriter = new PrintWriter(SocketHandler.getSocket().getOutputStream());
                printWriter.write(mess);
                runOnUiThread(new Runnable() {
                  public void run() {
                      Toast.makeText(getApplicationContext(),"Data send!",Toast.LENGTH_SHORT).show();
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

                    Toast.makeText(ConnectPC.this,"Khong co ket noi!\n Moi thu lai",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ConnectPC.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            }
             catch (IOException e) {
                e.printStackTrace();
               //  return null;
            }
            return null;
        }
    }

    static Intent getIntent(Context context) {
        Intent intent =  new Intent(context, ConnectPC.class);
        return intent;
    }
}
