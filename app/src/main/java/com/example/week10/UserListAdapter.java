package com.example.week10;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }
    Comparator<User> userComparator = Comparator.comparing(User::getLastName);

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Collections.sort(users, userComparator);
        holder.firstNameLastname.setText(new StringBuilder().append(users.get(position).getFirstName()).append(" ").append(users.get(position).getLastName()).toString());
        holder.degreeProgram.setText(users.get(position).getDegreeProgram());
        holder.email.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
