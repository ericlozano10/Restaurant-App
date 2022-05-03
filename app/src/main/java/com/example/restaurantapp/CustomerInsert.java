package com.example.restaurantapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomerInsert extends AppCompatActivity {
    //initialize variables
    EditText editText, tableNum;
    Button btnAdd,btnReset;
    RecyclerView recyclerView;
    List<CustomerData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    CustomerAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_customer_insert);
        //assign variables
        editText = findViewById(R.id.edit_text);
        tableNum = findViewById(R.id.table);
        btnAdd = findViewById(R.id.btn_add);
        btnReset = findViewById(R.id.btn_reset);
        recyclerView = findViewById(R.id.recycler_view2);

        //initialize database
        database = RoomDB.getInstance(this);
        //Store database value in data list
        dataList = database.customerDao().getAll();
        //initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        //Set Layout manager
        recyclerView.setLayoutManager(linearLayoutManager);
        //initialize adapter
        adapter = new CustomerAdapter(CustomerInsert.this,dataList);
        //set adapter
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get string from edit text
                String sText = editText.getText().toString().trim();
                String sTable = tableNum.getText().toString().trim();
                //check condition
                if(!sText.equals(""))
                {
                    //When text is not empty
                    //Initialize main data
                    CustomerData data = new CustomerData();
                    //set tet on Main data
                    sText = sText+" "+sTable;
                    data.setText(sText);
                    //insert text in database
                    database.customerDao().insert(data);
                    //clear edit text
                    editText.setText("");
                    tableNum.setText("");
                    //Notify when data inserted
                    dataList.clear();
                    dataList.addAll(database.customerDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Decline all data from database
                database.customerDao().reset(dataList);
                //Notify when all deleted
                dataList.clear();
                dataList.addAll(database.customerDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });

    }

}