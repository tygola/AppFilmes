package com.example.appfilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Mostrar_filme_Activity extends AppCompatActivity {
    TextView txtTitulo,txtAno,txtTipo;
    ImageView imgCapa;
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_filme_layout);

        txtTitulo = findViewById(R.id.mtxtTitulo);
        imgCapa = findViewById(R.id.mimgCapa);
        txtAno = findViewById(R.id.mtxtAno);
        txtTipo = findViewById(R.id.mtxtTipo);
        rating = findViewById(R.id.mratClass);

        Intent intent = getIntent();

        String TituloFilme = intent.getStringExtra("tituloFilme");
        int capaFilme = intent.getIntExtra("capaFilme",0);
        String anoFilme = intent.getStringExtra("anoFilme");
        String tipoFilme = intent.getStringExtra("tipoFilme");
        Float pontuacao = intent.getFloatExtra("ratingFilme",0);

        txtTitulo.setText(TituloFilme);
        imgCapa.setImageResource(capaFilme);
        txtAno.setText(anoFilme);
        txtTipo.setText(tipoFilme);
        rating.setRating(pontuacao);
    }
}
