package com.fer.aula05_itents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed01, ed02;
    SwitchCompat sw01;
    ImageView btn01;

    boolean troca = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed01 = findViewById(R.id.editTextText);
        ed02 = findViewById(R.id.editTextText2);
        sw01 = findViewById(R.id.switch1);
        btn01 = findViewById(R.id.imageView);

        sw01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                troca = b;
            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!ed01.getText().toString().isEmpty()
                && !ed02.getText().toString().isEmpty()) {
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("nome", ed01.getText().toString());
                    i.putExtra("email", ed02.getText().toString());
                    if(troca)
                        i.putExtra("troca", R.drawable.pac);
                    else
                        i.putExtra("troca", R.drawable.superm);
                    i.putExtra("valor", 3.5f);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Campos não podem ser nulos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}