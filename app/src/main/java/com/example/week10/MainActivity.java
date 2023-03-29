package com.example.week10;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserStorage.getInstance().loadUsers(this);
    }

    public void switchToAddStudent(View view){
        Intent intent = new Intent(this, AddNewUserActivity.class);
        startActivity(intent);

    }

    public void switchToListAllStudents(View view){
        Intent intent = new Intent(this, ListAllUsersActivity.class);
        startActivity(intent);
    }



}