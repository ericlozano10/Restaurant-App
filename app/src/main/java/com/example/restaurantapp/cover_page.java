package com.example.restaurantapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;


public class cover_page extends AppCompatActivity {
    public Button customer, owner,payment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cover_page);
        owner = findViewById(R.id.owner_bttn);
        customer = findViewById(R.id.customer_bttn);
        payment = findViewById(R.id.payment_bttn);

        customer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(cover_page.this, CustomerInsert.class);
                startActivity(intent);
            }
        });
        payment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent3 = new Intent(cover_page.this, Payment.class);
                startActivity(intent3);
            }
        });
        owner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent2= new Intent(cover_page.this, login.class);
                startActivity(intent2);
            }
        });
    }
}
