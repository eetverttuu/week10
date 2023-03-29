package com.example.week10;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserStorage {

    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage userStorage = null;

    private UserStorage(){
    }

    public static UserStorage getInstance(){
        if(userStorage==null){
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public ArrayList<User> getUsers() {
        return users;
    }


    public void removeUser(int id){

    }

    public void addUser(String firstName, String lastName, String email, String degreeProgram) {
        User newUser = new User(firstName, lastName, email, degreeProgram);
        users.add(newUser);
    }

    public void saveUser(Context context){
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            System.out.println("Käyttäjien tallentaminen onnistui");
            userWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Käyttäjien tallentaminen ei onnistunut");
        }
    }

    public void loadUsers (Context context){
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>)userReader.readObject();
            System.out.println("Käyttäjien lukeminen onnistui");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
        }

    }
}
