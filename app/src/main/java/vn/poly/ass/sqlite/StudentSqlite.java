package vn.poly.ass.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentSqlite extends SQLiteOpenHelper {
    public StudentSqlite(Context context) {
        super(context, "StudentManegament.db", null, 1);
    }

    public static class dbClass{
        public static String T_NAME ="Class";
        public static String C_ID="id";
        public static String C_NAME="name";
    }

    public static class dbStudent{
        public static  String C_ID = "id";
        public static String T_NAME ="Student";
        public static String C_NAME = "name";
        public static String C_BIRTHDAY = "birthday";
        public static  String C_IDCLASS = "idclass";
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createClassTable = "create table "+dbClass.T_NAME+"("+dbClass.C_ID + " varchar primary key, "+dbClass.C_NAME+" nvarchar) ";
        String createStudentTable = "create table "+dbStudent.T_NAME+"("+dbStudent.C_ID+" Integer primary key AUTOINCREMENT, "+dbStudent.C_NAME+" nvarchar, "+dbStudent.C_BIRTHDAY+" nvarchar, "+dbStudent.C_IDCLASS+" varchar)";
        db.execSQL(createClassTable);
        db.execSQL(createStudentTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
