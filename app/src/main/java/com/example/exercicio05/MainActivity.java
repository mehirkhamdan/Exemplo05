package com.example.exercicio05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProcessar;
    private TextView txtProgresso;
    private ProgressBar pgbContador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtProgresso = findViewById(R.id.txtProgresso);
        btnProcessar = findViewById(R.id.btnProcessar);
        pgbContador = findViewById(R.id.pgbContador);

        btnProcessar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

           ContadorTask contador = new ContadorTask(btnProcessar,txtProgresso,pgbContador);

           pgbContador.setMax(10);
           contador.execute(10);
        }


}