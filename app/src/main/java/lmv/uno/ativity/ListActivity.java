package lmv.uno.ativity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import lmv.uno.R;
import lmv.uno.modelo.Adapter;
import lmv.uno.modelo.Carta;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.lista);

        ArrayList<Carta> cartas = (ArrayList<Carta>) getIntent().getSerializableExtra("list");

        Adapter adapter = new Adapter(this, cartas);
        listView.setAdapter(adapter);
    }

    private ArrayList<Integer> obterImagens(ArrayList<Carta> cartas) {
        ArrayList<Integer> imagens = new ArrayList<>();

        for(Carta carta : cartas)
            imagens.add(carta.getImagemCarta());

        return imagens;
    }

    private ArrayList<String> obterCores(ArrayList<Carta> cartas) {
        ArrayList<String> cores = new ArrayList<>();

        for (Carta carta : cartas){
            switch (carta.getCor()){
                case Carta.COR_AZUL: cores.add("Azul"); break;
                case Carta.COR_VERDE: cores.add("Verde"); break;
                case Carta.COR_AMARELO: cores.add("Amarelo"); break;
                case Carta.COR_VERMELHO: cores.add("Vermelho"); break;
            }
        }
        return cores;
    }
}