package vn.poly.ass.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.poly.ass.model.Student;

public class Students {
    public StudentSqlite sqlite;

    public Students(Context context) {
        sqlite = new StudentSqlite(context);
    }


    public long insertData(Student student){
        SQLiteDatabase sqLiteDatabase = sqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentSqlite.dbStudent.C_NAME, student.getName());
        contentValues.put(StudentSqlite.dbStudent.C_BIRTHDAY, student.getBirthday());
        contentValues.put(StudentSqlite.dbStudent.C_IDCLASS, student.getIdClass());

        long result = sqLiteDatabase.insert(StudentSqlite.dbStudent.T_NAME, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public List<Student> getData(){
        List<Student> students = new ArrayList<>();
        String select = "select * from "+ StudentSqlite.dbStudent.T_NAME;
        SQLiteDatabase sqLiteDatabase = sqlite.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        if (cursor.moveToFirst()){
            do {
                students.add(new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return students;
    }
    public int deleteData(String id){
        SQLiteDatabase sqLiteDatabase = sqlite.getWritableDatabase();
        int result = sqLiteDatabase.delete(StudentSqlite.dbStudent.T_NAME, StudentSqlite.dbStudent.C_ID+"=?", new String[]{id});
        sqLiteDatabase.close();
        return result;
    }

    public long updateData(String id,String name,String birthday){
        SQLiteDatabase sqLiteDatabase = sqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentSqlite.dbStudent.C_NAME, name);
        contentValues.put(StudentSqlite.dbStudent.C_BIRTHDAY, birthday);

        long result = sqLiteDatabase.update(StudentSqlite.dbStudent.T_NAME, contentValues, StudentSqlite.dbStudent.C_ID+"=?", new String[]{id});
        sqLiteDatabase.close();
        return result;
    }
}

