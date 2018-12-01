package com.example.hryle.logindemo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class DataBaseCompte extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Compte.db"; //create a variable for our database
    private static final String TABLE_NAME = "Compte_table"; // create a variable for our table name

    public DataBaseCompte(Context context){

        super(context, DATABASE_NAME, null, 1); // it has to be a static variable

    }


    @Override // Creation database
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, MOUNTANT TEXT)");
    }

    @Override //Connection Database
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //method for inserting the data
    public boolean insertCompte(String name, String mountant){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("NAME",name); //the first value is for column name in a table and a second value is for the value to insert to the table
        contentValues.put("MOUNTANT",mountant);
        long result = db.insert (TABLE_NAME,null, contentValues);// when something went wrong, it will return -1
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor getAllCompte(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cu = db.rawQuery("select * from "+TABLE_NAME,null);
        return cu;
    }
}
