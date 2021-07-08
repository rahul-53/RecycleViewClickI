package com.example.recycleviewclick;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<StudentModel> studentList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildList();
        setRecyclerView();


    }

    private void setRecyclerView(){
        StudentAdapter studentAdapter = new StudentAdapter(studentList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);

    }

    private void buildList(){
        for (int i=0;i<20;i++){
            StudentModel studentModel =new StudentModel("Rahul Yadav","25","Bangalore","2/04/1998",R.drawable.ocean);
            studentList.add(studentModel);
        }
    }

    private void initView(){
        recyclerView=findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(StudentModel model, int position) {
        AlertDialog alertDialog =new AlertDialog.Builder(this)
                .setTitle("Hey this is student")
                .setMessage(
                        model.getName()+"\n"
                                + model.getAge()+"\n"
                                +model.getAddress()+"\n"
                ).show();

    }
}