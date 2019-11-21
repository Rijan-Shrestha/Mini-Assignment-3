package com.example.bottomnavigationwithfragment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationwithfragment.MainActivity;
import com.example.bottomnavigationwithfragment.adapter.StudentAdapter;
import com.example.bottomnavigationwithfragment.R;
import com.example.bottomnavigationwithfragment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    List<Student> students = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        recyclerView=root.findViewById(R.id.rvstudents);

        if(MainActivity.st.isEmpty()) {
            MainActivity.st.add(new Student("Rajesh Dai", "Male", "55", "Nepal"));
            MainActivity.st.add(new Student("Bangere", "Male", "25", "Nepal"));
            MainActivity.st.add(new Student("Rupak Neupane", "Male", "25", "Nepal"));

            StudentAdapter adapter = new StudentAdapter(MainActivity.st, getContext());

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());

            recyclerView.setLayoutManager(layoutManager);


            recyclerView.setAdapter(adapter);
        }else {


            StudentAdapter adapter2 = new StudentAdapter(MainActivity.st, getContext());

            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this.getContext());

            recyclerView.setLayoutManager(layoutManager2);


            recyclerView.setAdapter(adapter2);
        }



        return root;
    }
}