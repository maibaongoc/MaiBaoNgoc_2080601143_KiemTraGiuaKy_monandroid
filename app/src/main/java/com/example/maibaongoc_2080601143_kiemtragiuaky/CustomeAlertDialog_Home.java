package com.example.maibaongoc_2080601143_kiemtragiuaky;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class CustomeAlertDialog_Home extends Dialog {
    private HomeDAO homeDAO;

    EditText edtID, edtTen, edtEmail, edtKhoa,edtHinhAnh;

    Button btnsave, btnclear;


    public CustomeAlertDialog_Home(@NonNull Context context) {
        super(context);
        homeDAO= new HomeDAO(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_home);


        edtID = findViewById(R.id.txtInputManv);
        edtTen = findViewById(R.id.txtInputNameNhanVien);
        edtEmail = findViewById(R.id.txtInputEmail);
        edtKhoa = findViewById(R.id.txtInputKhoa);
        edtHinhAnh = findViewById(R.id.txtInputHinhAnh);



        btnsave = findViewById(R.id.btnSave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isDataValid()){
                    saveData();
                    Toast.makeText(getContext(), "Lưu thành công",
                            Toast.LENGTH_SHORT).show();
                    xoaThongTin();
                }
                else {
                    Toast.makeText(getContext(), "Chưa nhập đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnclear = findViewById(R.id.btnClear);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isDataValid()){
                    deleteData();
                    Toast.makeText(getContext(), "Xóa thành công",
                            Toast.LENGTH_SHORT).show();
                    xoaThongTin();
                }
                else {
                    Toast.makeText(getContext(), "Chưa nhập đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void xoaThongTin(){
        edtID.setText("");
        edtTen.setText("");
    }
    //hàm lưu thông tin xuống SQLite
    private void saveData(){
        String ID= edtID.getText().toString().trim();
        String Ten= edtTen.getText().toString().trim();
        String Email= edtEmail.getText().toString().trim();
        String Khoa= edtKhoa.getText().toString().trim();
        String HinhAnh= edtHinhAnh.getText().toString().trim();
        Home home = new Home(ID, Ten,Email,Khoa,HinhAnh);
        homeDAO.Insert(home);
    }

    private void deleteData(){
        String ID= edtID.getText().toString().trim();
        String Ten= edtTen.getText().toString().trim();
        String Email= edtEmail.getText().toString().trim();
        String Khoa= edtKhoa.getText().toString().trim();
        String HinhAnh= edtHinhAnh.getText().toString().trim();
        Home home = new Home(ID, Ten,Email,Khoa,HinhAnh);
        homeDAO.Delete(ID);
    }



    //hàm kiểm tra xem người dùng đã nhập đủ thông tin chưa
    private boolean isDataValid(){
        String ID= edtID.getText().toString().trim();
        String Ten= edtTen.getText().toString().trim();
        String Email= edtEmail.getText().toString().trim();
        String Khoa= edtKhoa.getText().toString().trim();
        String HinhAnh= edtHinhAnh.getText().toString().trim();
        return !ID.isEmpty() && !Ten.isEmpty()&& !Email.isEmpty()&& !Khoa.isEmpty()&& !HinhAnh.isEmpty();
    }
}
