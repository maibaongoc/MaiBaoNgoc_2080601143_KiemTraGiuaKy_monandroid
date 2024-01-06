package com.example.maibaongoc_2080601143_kiemtragiuaky;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maibaongoc_2080601143_kiemtragiuaky.CustomeAlertDialog;
import com.example.maibaongoc_2080601143_kiemtragiuaky.Khoa;
import com.example.maibaongoc_2080601143_kiemtragiuaky.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class Khoa_Fragment extends Fragment {

    private static List<Khoa> listKhoa = Khoa.getListKhoa();

    FloatingActionButton floatingActionButton;

    RecyclerView recyclerView;

    private KhoaAdapter adapter;
    private ItemTouchHelper itemTouchHelper;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_khoa, container, false);



        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        recyclerView = view.findViewById(R.id.rcvkhoa);

        itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        // Hàm lấy danh sách product
        KhoaDAO productDAO = new KhoaDAO(getActivity());
        List<Khoa> khoaList = productDAO.GetAll();

        // Đổ dữ liệu lên productAdapter
        KhoaAdapter productAdapter = new KhoaAdapter(khoaList);
        // Gán dữ liệu vào RecyclerView
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Xử lý khi nhấn FloatingActionButton
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomeAlertDialog customeAlertDialog = new CustomeAlertDialog(getActivity()); // Tạo đối tượng dialog khi cần hiển thị
                customeAlertDialog.show();
            }
        });

        return view;

    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            listKhoa.remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();
        }
    };
}
