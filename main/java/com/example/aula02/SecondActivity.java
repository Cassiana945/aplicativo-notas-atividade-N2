package com.example.aula02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class SecondActivity extends AppCompatActivity {

    Button btnVoltar;
    RecyclerView recyclerView;
    ArrayList<String> notas;
    NotaAdapter notaAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        recyclerView = findViewById(R.id.recycler);


        Intent intent = getIntent();
        notas = intent.getStringArrayListExtra("var");


        if (notas == null) {
            notas = new ArrayList<>();
        }

        ArrayList<String> organizarNotas = new ArrayList<>(notas);
        Collections.sort(organizarNotas);
        notas.clear();
        notas.addAll(organizarNotas);

        notaAdapter = new NotaAdapter( SecondActivity.this, notas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notaAdapter);


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}