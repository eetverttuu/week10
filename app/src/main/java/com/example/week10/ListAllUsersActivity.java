package com.example.week10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListAllUsersActivity extends AppCompatActivity {

    private UserStorage userStorage;
    private RecyclerView  recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_users);
        userStorage = UserStorage.getInstance();
        recyclerView = findViewById(R.id.rvUserList);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        recyclerView.setAdapter(new UserListAdapter(getApplicationContext(), userStorage.getUsers()));
    }


}