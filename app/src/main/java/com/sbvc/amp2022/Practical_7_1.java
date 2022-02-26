package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Practical_7_1 extends AppCompatActivity {

    FloatingActionButton btnAddEmployee;
    ListView lstEmployee;
    MyDBHelper myDBHelper;
    List<Employee> employeeList = new ArrayList<Employee>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical71);

        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        lstEmployee = findViewById(R.id.lstEmployee);

        myDBHelper = new MyDBHelper(getApplicationContext());

        employeeList = myDBHelper.getAllEmployees();

        for (Employee e : employeeList
        ) {
            Toast.makeText(this, "Name : " + e.getSName(), Toast.LENGTH_SHORT).show();
        }
        myAdapter = new MyAdapter(getApplicationContext(), employeeList);
        lstEmployee.setAdapter(myAdapter);

        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_7_1_1.class));
            }
        });
    }
}