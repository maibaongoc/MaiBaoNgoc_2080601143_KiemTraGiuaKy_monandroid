package com.example.maibaongoc_2080601143_kiemtragiuaky;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HomeHelper extends SQLiteOpenHelper {

    public HomeHelper(@Nullable Context context)
    {
        super(context, "QLNV", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = String.format("CREATE TABLE %s (" + "%s INTEGER PRIMARY KEY AUTOINCREMENT, " + "%s TEXT," +"%s TEXT,"+"%s TEXT,"+"%s TEXT)", "NhanVien", "id", "ten_nv","email","khoa","hinhanh");
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion != newVersion) {
            //drop
            String query = "DROP TABLE NhanVien";
            db.execSQL(query);
            //create again
            onCreate(db);
        }
    }

}
