package vn.poly.ass.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.poly.ass.model.Class;

public class Controller {
    public StudentSqlite sqlite;

    public Controller(Context context){
        sqlite = new StudentSqlite(context);
    }
    public long insertData(Class aClass){
        SQLiteDatabase sqLiteDatabase = sqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentSqlite.dbClass.C_ID,aClass.getId());
        contentValues.put(StudentSqlite.dbClass.C_NAME, aClass.getName());

        long result = sqLiteDatabase.insert(StudentSqlite.dbClass.T_NAME, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public List<Class> getData(){
        List<Class> classes=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqlite.getReadableDatabase();
        String select = "select * from "+ StudentSqlite.dbClass.T_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        if (cursor.moveToFirst()){
            do {
                classes.add(new Class(cursor.getString(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return classes;
    }

    public long deleteData(String id){
        SQLiteDatabase sqLiteDatabase = sqlite.getWritableDatabase();
        long result = sqLiteDatabase.delete(StudentSqlite.dbClass.T_NAME, StudentSqlite.dbClass.C_ID+"=?", new String[]{id});
        sqLiteDatabase.close();
        return result;
    }

    public long updateData(String id,String newId,String name){
        SQLiteDatabase sqLiteDatabase = sqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentSqlite.dbClass.C_ID, newId);
        contentValues.put(StudentSqlite.dbClass.C_NAME, name);
        long result = sqLiteDatabase.update(StudentSqlite.dbClass.T_NAME, contentValues, StudentSqlite.dbClass.C_ID+"=?", new String[]{id});
        sqLiteDatabase.close();
        return result;
    }
}


