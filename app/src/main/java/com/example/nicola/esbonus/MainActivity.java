package com.example.nicola.esbonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()) {

                    Intent showResults = new Intent(MainActivity.this, ShowActivity.class);

                    showResults.putExtra("Name", name.getText().toString());
                    showResults.putExtra("Pass", password.getText().toString());

                    startActivity(showResults);
                }
            }
        });
    }
    private boolean checkInput()
    {
        int errors = 0;

        if(name.getText()==null || name.getText().length()==0) {
            name.setError("Insert name");
            errors++;
        }
        else
            name.setError(null);

        if(password.getText()==null || password.getText().length()==0) {
            password.setError("Insert password");
            errors++;
        }
        else
            password.setError(null);

        return errors==0;
    }



}
