package com.example.nicola.esbonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    TextView resultText;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        resultText = findViewById(R.id.result);
        back = findViewById(R.id.back);

        String result;
        Intent intent = getIntent();
        if(isSignUp(intent.getStringExtra("Name"), intent.getStringExtra("Pass"))){
            result = "Benvenuto " + intent.getStringExtra("Name");
        }
        else{
            result = "Accesso Negato!";
        }
        resultText.setText(result);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public boolean isSignUp(String name, String pass){
        return (name.equals("Esercitazione") && pass.equals("bonus")) ||
                (name.equals("Paolo") && pass.equals("Rossi"));
    }
}
