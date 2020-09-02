package com.example.sql_lite_revision;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


import static java.lang.Integer.parseInt;

public class sql_test extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "my_DB";
    public static final int DATABASE_virsion = 1;
    public static final String TABLE_NAME = "Notes";
    static final String Key_id = "id";
    static final String Key_title = "title";
    static final String Key_desc = "description";


    public sql_test(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_virsion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table = "create table " + TABLE_NAME + " ( " + Key_id + " integer primary key , "
                + Key_title + " varchar(30) , "
                +Key_desc + " varchar(70) )";

        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String delete_query = "Drop TABLE " +TABLE_NAME + " IF EXISTS";
        sqLiteDatabase.execSQL(delete_query);
        onCreate(sqLiteDatabase);

    }

    public void add_node(model model){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Key_title , model.getTitle());
        contentValues.put(Key_desc, model.getDesc());
        database.insert(TABLE_NAME,null,contentValues);
    }



    public ArrayList<model> get_my_notes (){
        ArrayList<model> arrayList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String select_all = "select * from " +TABLE_NAME ;
        Cursor cursor = database.rawQuery(select_all,null);
        if (cursor.moveToFirst()){
            do {
                String stored_title =cursor.getString(cursor.getColumnIndex(Key_title));
                String stored_desc =cursor.getString(cursor.getColumnIndex(Key_desc));
                arrayList.add(new model(stored_title,stored_desc));
            }while (cursor.moveToNext());
        }

        return arrayList;

    }
    public model get_contact_by_id (String id){
        SQLiteDatabase database = this.getReadableDatabase();
        int my = parseInt(id)+1;
        String select_query = "select * from  " +TABLE_NAME + " where id ="+my;
        Cursor cursor = database.rawQuery(select_query , null);
        model model = null;
        if (cursor.moveToFirst()){
            String stored_title = cursor.getString(cursor.getColumnIndex(Key_title));
            String stored_desc = cursor.getString(cursor.getColumnIndex(Key_desc));
            model =new model(stored_title,stored_desc) ;
            return model;

        }
        return model;

    }

    public void Update_data(model model){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(Key_title , model.getTitle());
        contentValues.put(Key_desc , model.getDesc());
        int temp = Integer.parseInt(model.getId())+1;
        String S_temp = String.valueOf(temp);
        database.update(TABLE_NAME ,contentValues ,"id=?",new String[]{S_temp});

        database.close();
    }

    public void Delete_data(String id){
        int temp = Integer.parseInt(id)+1;
        String S_temp = String.valueOf(temp);
        SQLiteDatabase database=this.getWritableDatabase();
        database.delete(TABLE_NAME ,"id=?" , new String[]{S_temp} );

    }


}
