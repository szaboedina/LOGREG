package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdatbazisSegito extends SQLiteOpenHelper {


    public  static final String DATABASE_NAME= "LogRegAdatbazis.db";
    public static final String TABLE_NAME="felhasznalo";

    public static final String COL_1="id";
    public static final String COL_2="email";
    public static final String COL_3="felhnev";
    public static final String COL_4="jelszo";
    public static final String COL_5="teljesnev";
    public AdatbazisSegito(Context context) {
        super(context, DATABASE_NAME, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "email TEXT NOT NULL," + "felhnev TEXT NOT NULL," + "jelszo TEXT NOT NULL," + "teljesnev TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }
    public boolean adatRogzites(String email, String felhnev, String jelszo,String teljesnev){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, felhnev);
        contentValues.put(COL_4, jelszo);
        contentValues.put(COL_5, teljesnev);

        long eredmeny = database.insert(TABLE_NAME,null,contentValues);
        if (eredmeny==-1)
            return false;
        else
            return true;
    }
    public Cursor bejeletkezes(){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return eredmeny;
    }
}
