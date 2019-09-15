package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView txtImc;
    TextView txtCategoria;
    TextView txtSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        Float result = Float.valueOf(intent.getStringExtra("result"));

        txtImc = findViewById(R.id.txtImc);
        txtCategoria = findViewById(R.id.txtCategoria);
        txtSobre = findViewById(R.id.txtSobre);

        txtImc.setText(String.format("%.2f", result));

        if ( result < 16 ) {
            txtCategoria.setText(getResources().getString(R.string.app_magreza_grave));
            txtSobre.setText(getResources().getString(R.string.app_magreza_grave_desc));
        } else if ( result >= 16 && result < 17) {
            txtCategoria.setText(getResources().getString(R.string.app_magreza_moderada));
            txtSobre.setText(getResources().getString(R.string.app_magreza_moderada_desc));
        } else if ( result >= 17 && result < 18.5 ) {
            txtCategoria.setText(getResources().getString(R.string.app_magreza_leve));
            txtSobre.setText(getResources().getString(R.string.app_magreza_leve_desc));
        } else if ( result >= 18.5 && result < 25 ) {
            txtCategoria.setText(getResources().getString(R.string.app_saudavel));
            txtSobre.setText(getResources().getString(R.string.app_saudavel_desc));
        } else if ( result >= 25 && result < 30 ) {
            txtCategoria.setText(getResources().getString(R.string.app_sobrepeso));
            txtSobre.setText(getResources().getString(R.string.app_sobrepeso_desc));
        } else if ( result >= 30 && result < 35 ) {
            txtCategoria.setText(getResources().getString(R.string.app_obesidade_i));
            txtSobre.setText(getResources().getString(R.string.app_obesidade_i_desc));
        } else if ( result >= 35 && result < 40 ) {
            txtCategoria.setText(getResources().getString(R.string.app_obesidade_ii));
            txtSobre.setText(getResources().getString(R.string.app_obesidade_ii_desc));
        } else {
            txtCategoria.setText(getResources().getString(R.string.app_obesidade_iii));
            txtSobre.setText(getResources().getString(R.string.app_obesidade_iii_desc));
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
