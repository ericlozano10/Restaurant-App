package com.example.restaurantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private FirebaseAuth myAuth;
    private EditText email, pass, name;
    private Button register;
    private TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myAuth = FirebaseAuth.getInstance();

        //variables
        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        pass = findViewById(R.id.editPassword);
        register = findViewById(R.id.register_bttn);
        signIn = findViewById(R.id.textViewSignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.register_bttn){
                    registerUser();
                }
            }

            private void registerUser() {
                String nameStr = name.getText().toString().trim();
                String emailStr = email.getText().toString().trim();
                String passStr = pass.getText().toString().trim();

                //check if name is empty
                if(nameStr.isEmpty()){
                    name.setError("Name is required.");
                    name.requestFocus();
                    return;
                }

                //check if email is empty
                if(emailStr.isEmpty()){
                    email.setError("Email is required.");
                    email.requestFocus();
                    return;
                }
                //check if email follows email format
                if(!Patterns.EMAIL_ADDRESS.matcher(emailStr).matches()){
                    email.setError("Please provide a valid email.");
                    email.requestFocus();
                    return;
                }
                //check if password is empty
                if(passStr.isEmpty()){
                    pass.setError("Password is required.");
                    pass.requestFocus();
                    return;
                }
                //check if it meets firebase min length
                if(passStr.length() < 6){
                    pass.setError("Password length must be at least 6 characters.");
                    pass.requestFocus();
                    return;
                }
                myAuth.createUserWithEmailAndPassword(emailStr, passStr)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    User user = new User(nameStr, emailStr);
                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(register.this, "User has been registered!", Toast.LENGTH_SHORT).show();
                                            }
                                            else{
                                                Toast.makeText(register.this,"Failed to register. Try again.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                                else{
                                    Toast.makeText(register.this,"Failed to register. Try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}