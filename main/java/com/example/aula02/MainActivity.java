package com.example.aula02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnOrganizar;
    EditText nota1, nota2, nota3, nota4, nota5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnOrganizar = findViewById(R.id.btnOrganizar);
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        nota5 = findViewById(R.id.nota5);

        btnOrganizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nota1.getText().toString().isEmpty() &&
                        nota2.getText().toString().isEmpty() &&
                        nota3.getText().toString().isEmpty() &&
                        nota4.getText().toString().isEmpty() &&
                        nota5.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha pelo menos uma nota", Toast.LENGTH_SHORT).show();

                } else {

                    ArrayList<String> notas = new ArrayList<>();

                    if (!nota1.getText().toString().isEmpty()) {
                        notas.add(nota1.getText().toString());
                    }
                    if (!nota2.getText().toString().isEmpty()) {
                        notas.add(nota2.getText().toString());
                    }
                    if (!nota3.getText().toString().isEmpty()) {
                        notas.add(nota3.getText().toString());
                    }
                    if (!nota4.getText().toString().isEmpty()) {
                        notas.add(nota4.getText().toString());
                    }
                    if (!nota5.getText().toString().isEmpty()) {
                        notas.add(nota5.getText().toString());
                    }

                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putStringArrayListExtra("var", notas);
                    startActivity(i);
                    finish();
                }
            }
        });

    }
}
