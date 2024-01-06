package com.example.maibaongoc_2080601143_kiemtragiuaky;

import java.util.ArrayList;
import java.util.List;

public class Home {

    public Home()
    {

    }


    public Home(String maso, String ten, String email, String khoa, String hinhanh) {
        this.maso = maso;
        this.ten = ten;
        this.email = email;
        Khoa = khoa;
        Hinhanh = hinhanh;
    }

    private String maso;

    private String ten;

    private String email;

    private String Khoa;

    private String Hinhanh;

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        Hinhanh = hinhanh;
    }





    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }
    public static List<Home> getListHome(){
        List<Home> lsHome = new ArrayList<>();

        return lsHome;
    }


}
