/*
package com.example.sql_lite_revision;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Notes_DB extends SQLiteOpenHelper {
    static final String DB_NAME = "myDB";
    static final int DB_VERSION = 1;
    //static final String Table_NAME = "my_notes";
    static final String Key_id = "id";
    static final String Key_title = "title";
    static final String Key_desc = "description";


    public Notes_DB(@Nullable Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CreateTable = "create table " +Table_NAME + " (" + Key_id + " integer primary key , "
                + Key_title + " varchar(30) , "
                + Key_desc +  " integer ) " ;



            sqLiteDatabase.execSQL(CreateTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String delete_query = "Drop TABLE " +Table_NAME + " IF EXISTS";
        sqLiteDatabase.execSQL(delete_query);
        onCreate(sqLiteDatabase);
    }

    // function add note
    public void add_node(model model,Context context){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_title , model.getTitle());
        values.put(Key_desc , model.getDesc());
        database.insert(Table_NAME , null , values);


    }


    ///////////////////////
    public ArrayList<model> get_my_notes (){
        ArrayList<model> modelArrayList = new ArrayList<>();
        String Select_query  = "select * from  " +Table_NAME;
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery(Select_query , null);
        if (cursor.moveToFirst()){
            do {

                String stored_title = cursor.getString(cursor.getColumnIndex(Key_title));
                String stored_desc = cursor.getString(cursor.getColumnIndex(Key_desc));
                modelArrayList.add(new model(stored_title,stored_desc));

            }while (cursor.moveToNext());
        }

        return modelArrayList;

    }

    //////////////////////
    */
/*public void Update_data(model model){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(Key_title , model.getTitle());
        contentValues.put(Key_desc , model.getDesc());
        database.update(Table_NAME ,contentValues ,"id=?",new String[]{String.valueOf(model.getId())} );

        database.close();
    }*//*


   */
/* public model get_contact_by_id (String id){
    SQLiteDatabase database = this.getReadableDatabase();
       int my = parseInt(id);
        String select_query = "select * from  " +Table_NAME + " where title="+my;
        Cursor cursor = database.rawQuery(select_query , null);
        model model = null;
        if (cursor.moveToFirst()){
        String stored_title = cursor.getString(cursor.getColumnIndex(Key_title));
        String stored_desc = cursor.getString(cursor.getColumnIndex(Key_desc));
        model =new model(stored_title,stored_desc) ;
        return model;

        }
        return model;

    }*//*

};
*/
