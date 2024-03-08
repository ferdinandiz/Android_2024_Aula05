package com.fer.aula05_itents;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
   TextView txt01, txt02;
   ImageView img01, img02;
   String nome, email;
   int troca;
   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {

      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_second);
      txt01 = findViewById(R.id.texto01);
      txt02 = findViewById(R.id.texto02);
      img01 = findViewById(R.id.imagem);
      img02 = findViewById(R.id.btn_voltar);

      //Dados Vindos da Intent
      Intent telaAnterior = getIntent();
      nome = telaAnterior.getStringExtra("nome");
      email = telaAnterior.getStringExtra("email");
      troca = telaAnterior.getIntExtra("troca",0);
      float value = telaAnterior.getFloatExtra("valor",0f);

      //Utilização dos valores vindo da Intent
      Toast.makeText(this, "Valor Float: "+value, Toast.LENGTH_SHORT).show();
      txt01.setText(nome);
      txt02.setText(email);
      img01.setImageResource(troca);
      if(troca == R.drawable.pac){
         txt01.setTextColor(Color.BLACK);
         txt02.setTextColor(Color.BLACK);
      }

      img02.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent i = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(i);
            finish();
         }
      });

   }
}
