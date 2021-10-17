package com.example.exercicio05;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class ContadorTask extends AsyncTask<Integer, Integer, Void> {

    private Button btnProcessar;
    private TextView txtProgresso;
    private ProgressBar pgbContador;

    public ContadorTask(Button btnProcessar, TextView txtProgresso, ProgressBar pgbContador){

        this.btnProcessar = btnProcessar;
        this.txtProgresso = txtProgresso;
        this.pgbContador = pgbContador;

    }

    @Override
    protected void onPreExecute(){

        btnProcessar.setEnabled(false);
        txtProgresso.setVisibility(View.VISIBLE);
        pgbContador.setVisibility(View.INVISIBLE);
        pgbContador.setProgress(0);
    }

    protected Void doInBackground(Integer... integers) {

        int max = 10;

        for(int i = max; i >= 0; i--){
            SystemClock.sleep( 1000);
            publishProgress(i);

        }
        return null;
    }



    @Override
    protected void onProgressUpdate(Integer... values) {

        int p = values[0];
        pgbContador.setProgress(p);
        txtProgresso.setText(String.valueOf(p));


    }


    protected void onPostExecute(Void aVoid) {

        btnProcessar.setEnabled(true);
        txtProgresso.setVisibility(View.VISIBLE);
        pgbContador.setVisibility(View.INVISIBLE);
        txtProgresso.setText(R.string.fim);

    }


}
