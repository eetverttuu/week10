package com.example.week10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.SQLOutput;


public class AddNewUserActivity extends AppCompatActivity {

    private EditText firstName, lastName, email;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        firstName = findViewById(R.id.txtUserFirstName);
        lastName = findViewById(R.id.txtUserLastName);
        email = findViewById(R.id.txtUserEmail);
        context = this;
    }

    public void addUser(View view) {
        UserStorage us = UserStorage.getInstance();
        RadioGroup rgDegreeProgram = findViewById(R.id.rgDegreeType);
        String degreeProgram = null;
        switch (rgDegreeProgram.getCheckedRadioButtonId()) {
            case R.id.rdTite:
                degreeProgram = "Tietotekniikka";
                break;
            case R.id.rdEnte:
                degreeProgram = "Energiatekniikka";
                break;
            case R.id.rdTuta:
                degreeProgram = "Tuotantotalous";
                break;
            case R.id.rdLate:
                degreeProgram = "Laskennallinen tekniikka";
                break;
        }
        us.addUser(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), degreeProgram);
        saveUser(view);
        System.out.println(context.getFilesDir().toString());
        System.out.println("TESTITETSTSHSHHSHSHSHSHSGHSJDGGDGDJDGH");

    }

    public void selectSchool(View view){
    }

    public void finalSelection(View view){
    }

    private void saveUser(View view){
        UserStorage.getInstance().saveUser(context);
    }
}