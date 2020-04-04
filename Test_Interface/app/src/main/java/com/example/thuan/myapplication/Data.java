package com.example.thuan.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class Data extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="application";
    private final Context context;
    public Data(Context context) {
        super(context, DATABASE_NAME,null, 1);
        Log.d("DBManager", "DBManager: ");

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE if not exists test" +" (" +
                "id interger,"+
                 "x interger,"+
                 "y interger"+")";
        db.execSQL(sqlQuery);
        db.execSQL("Insert into test"+ " values(1,50,100)");
        db.execSQL("Insert into test"+ " values(2,150,150)");
        db.execSQL("Insert into test"+ " values(3,250,200)");
        db.execSQL("Insert into test"+ " values(4,50,200)");
        db.execSQL("Insert into test"+ " values(5,50,300)");
        db.execSQL("Insert into test"+ " values(6,250,300)");
        db.execSQL("Insert into test"+ " values(7,250,400)");
        db.execSQL("Insert into test"+ " values(8,250,100)");
        db.execSQL("Insert into test"+ " values(9,150,300)");

//        Buton btn=new Buton(1,50,100);
//        AddButton(btn);
//        btn=new Buton(1,100,200);
//        AddButton(btn);
//        btn=new Buton(1,150,200);
//        AddButton(btn);
//        btn=new Buton(1,50,200);
//        AddButton(btn);
//        btn=new Buton(1,150,400);
//        AddButton(btn);
//        btn=new Buton(1,200,300);
//        AddButton(btn);
//        btn=new Buton(1,250,300);
//        AddButton(btn);
//        btn=new Buton(1,300,450);
//        AddButton(btn);
//        btn=new Buton(1,300, 250);
//        AddButton(btn);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int new_version) {
        db.execSQL("DROP TABLE IF EXISTS test");
        onCreate(db);
    }

    public void AddButton(Buton btn)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",btn.getId());
        values.put("x", btn.getX());
        values.put("y", btn.getY());
        db.insert("test",null,values);
        db.close();
    }

    public int Update(Buton btn){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",btn.getId());
        values.put("x", btn.getX());
        values.put("y", btn.getY());
        int res = db.update("test",values,"id = ?",new String[] { String.valueOf(btn.getId())});
        db.close();
        return res;
    }

    public ArrayList<Buton> getData(){
        ArrayList<Buton> arrs=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql="SELECT * FROM test";
        Cursor cursor= db.rawQuery(sql,null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Buton btn = new Buton();
                btn.setId(cursor.getInt(0));
                btn.setX(cursor.getInt(1));
                btn.setY(cursor.getInt(2));
                arrs.add(btn);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return arrs;
    }


}
