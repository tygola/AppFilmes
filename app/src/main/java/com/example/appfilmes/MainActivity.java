package com.example.appfilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView ListarFilmes;

    String[] nomeFilme = {"American Gods",
            "Breaking Bad",
            "Blacklist",
            "boys",
            "Dark",
            "Dracula",
            "Freud",
            "Game Of Thrones",
            "Grimm",
            "The last Kingdom",
            "Lucifer",
            "Mr.Robot",
            "Peaky Blinders",
            "Supernatural",
            "Sleepy HolloW",
            "Sons of Anarchy",
            "Titans",
            "Vikings",
            "Da Vinci Demons",
            "The Witcher"};
    int[] capaFilme = {R.drawable.ameri,
            R.drawable.bb,R.drawable.black,R.drawable.boys,R.drawable.dark,R.drawable.dracula,R.drawable.freud,
            R.drawable.got,R.drawable.grimm,R.drawable.last,R.drawable.lu,R.drawable.mr,R.drawable.peaky,R.drawable.s15,
            R.drawable.slee,R.drawable.sons,R.drawable.titans,R.drawable.viks,R.drawable.vinci,R.drawable.wi};
    String[] tipoFilme = {"\"Drama\",\"Drama\",\"Drama\",\"Drama\",\"Drama\",\"Terror\",\"Suspense\",\"Terror\",\"Historia\",\"Misterio\",\"Drama\",\"Drama\",\"Terror\",\"Terror\",\"Drama\",\"Drama\",\"Drama\",\"Drama\",\"drama\""};
    String[] anoFilme = {"2017","2008","2013","2019","2017","2020","2020","2013","2015","2016","2015","2013","2005","2013","2008","2018","2013","2013","2019"};
    float[] ratingFilme = {4f, 4f,4f,4.5f,3.8f,3.5f,4f,4,5f,3f,4f,3.5f,3f,4f,5f,5f,3.5f,4f,3.5f,5f,4f};
    private int modelo_filme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListarFilmes = findViewById(R.id.listarFilmes);

        CustomAdapter adapter = new CustomAdapter();

        ListarFilmes.setAdapter(adapter);

        ListarFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Mostrar_filme_Activity.class);

                intent.putExtra("tituloFilme", nomeFilme[position]);
                intent.putExtra("capaFilme", capaFilme[position]);
                intent.putExtra("tipoFilme", tipoFilme[position]);
                intent.putExtra("anoFilme", anoFilme[position]);
                intent.putExtra("ratingFilme", ratingFilme[position]);


                startActivity(intent);

            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return capaFilme.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView txtTipoFilme, txtAnoFilme;
            ImageView imgCapaFilme;
            RatingBar ratFilme;

            View carregaView = getLayoutInflater().inflate(modelo_filme, null);

            TextView txtNomeFilme = carregaView.findViewById(R.id.txtListaTitulo);
            txtTipoFilme = carregaView.findViewById(R.id.txtListaCategoria);
            txtAnoFilme = carregaView.findViewById(R.id.txtListaAano);

            imgCapaFilme = carregaView.findViewById(R.id.imgListaCapa);
            ratFilme = carregaView.findViewById(R.id.ratListaPontuacao);

            txtNomeFilme.setText(nomeFilme[position]);
            txtTipoFilme.setText(tipoFilme[position]);
            txtAnoFilme.setText(anoFilme[position]);
            imgCapaFilme.setImageResource(capaFilme[position]);
            ratFilme.setRating(ratingFilme[position]);


            return carregaView;
        }
    }
}


