package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso;
    EditText edtAltura;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float peso;
                float altura;

                if (TextUtils.isEmpty(edtPeso.getText().toString())) {
                    peso = 0F;
                } else {
                    peso = Float.parseFloat(edtPeso.getText().toString().trim());
                }

                if (TextUtils.isEmpty(edtAltura.getText().toString())) {
                    altura = 0F;
                } else {
                    altura = Float.parseFloat(edtAltura.getText().toString().trim());
                }

                if (checkValoresValidos(peso, altura)) {
                    Intent intent = new Intent(getApplicationContext(), Resultado.class);
                    intent.putExtra("result", Float.toString(peso/(altura*altura)));
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.app_error_message), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean checkValoresValidos(float peso, float altura) {
        return peso > 0F && altura > 0F;
    }
}
