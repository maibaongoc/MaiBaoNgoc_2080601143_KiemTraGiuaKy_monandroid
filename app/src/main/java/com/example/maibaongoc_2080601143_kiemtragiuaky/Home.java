package com.example.maibaongoc_2080601143_kiemtragiuaky;

import java.util.ArrayList;
import java.util.List;

public class Home {
    public Home(String ten, String maso, float dtb, String khoa) {
        this.ten = ten;
        this.maso = maso;
        this.dtb = dtb;
        Khoa = khoa;
    }

    private String ten;
    private String maso;
    private float dtb;

    private String Khoa;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public float getDtb() {
        return dtb;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }
    public static List<Home> getListHome(){
        List<Home> lsKhoa = new ArrayList<>();

        return lsKhoa;
    }


}
