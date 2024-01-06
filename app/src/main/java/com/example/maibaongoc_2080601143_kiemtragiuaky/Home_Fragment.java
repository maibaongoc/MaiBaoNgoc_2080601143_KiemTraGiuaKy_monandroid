package com.example.maibaongoc_2080601143_kiemtragiuaky;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maibaongoc_2080601143_kiemtragiuaky.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class Home_Fragment extends Fragment {

    private static List<Khoa> listKhoa = Khoa.getListKhoa();

    FloatingActionButton floatingActionButton;

    RecyclerView recyclerView;

    private HomeAdapter adapter;
    private ItemTouchHelper itemTouchHelper;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater,container,savedInstanceState);
        View view= inflater.inflate(R.layout.fragment_home,container,false);

        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        recyclerView = view.findViewById(R.id.rcvnhanvien);

        itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        // Hàm lấy danh sách product
        HomeDAO homeDAO = new HomeDAO(getActivity());
        List<Home> homeList = homeDAO.GetAll();

        // Đổ dữ liệu lên productAdapter
        HomeAdapter homeAdapter = new HomeAdapter(homeList);
        // Gán dữ liệu vào RecyclerView
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Xử lý khi nhấn FloatingActionButton
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomeAlertDialog_Home customeAlertDialog_home = new CustomeAlertDialog_Home(getActivity()); // Tạo đối tượng dialog khi cần hiển thị
                customeAlertDialog_home.show();
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