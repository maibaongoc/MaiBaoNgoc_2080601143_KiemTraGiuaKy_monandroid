package com.example.maibaongoc_2080601143_kiemtragiuaky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class HomeDAO {
    HomeHelper homeHelper;

    public HomeDAO(Context context)
    {
        homeHelper = new HomeHelper(context);
    }

    public List<Home> GetAll()
    {
        SQLiteDatabase db = homeHelper.getWritableDatabase();
        List<Home> listProduct = new ArrayList<>();
        String query = "SELECT * FROM NhanVien";
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext())
        {
            Home temp = new Home();
            temp.setMaso(c.getString(0));
            temp.setTen(c.getString(1));
            temp.setEmail(c.getString(2));
            temp.setKhoa(c.getString(3));
            temp.setHinhanh(c.getString(4));
            listProduct.add(temp);
        }
        return listProduct;
    }

    public void Insert(Home p) {

        SQLiteDatabase db = homeHelper.getWritableDatabase();
        //c1: sử dụng contentValues
        ContentValues values = new ContentValues();
//        values.put("id", p.getMaso());
        values.put("ten_nv", p.getTen());
        values.put("email", p.getEmail());
        values.put("khoa", p.getKhoa());
        values.put("hinhanh", p.getHinhanh());
        long newRowId =db.insert("NhanVien", null, values);

        if (newRowId != -1) {
            // The data was successfully inserted
            Log.d("Insert", "Data inserted successfully with row ID: " + newRowId);
        } else {
            // There was an error inserting the data
            Log.e("Insert", "Error inserting data into the database");
        }
    }

    public void Delete(String nhanvienId) {
        SQLiteDatabase db = homeHelper.getWritableDatabase();
        //c1: sử dụng delete
        db.delete("NhanVien", "id=?", new String[]{String.valueOf(nhanvienId)});
    }


}
