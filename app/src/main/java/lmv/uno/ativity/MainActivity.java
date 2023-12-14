package lmv.uno.ativity;

import com.google.gson.Gson;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import lmv.uno.ImageNameMapper;
import lmv.uno.R;
import lmv.uno.bd.CardDatabaseHelper;
import lmv.uno.modelo.Carta;
import lmv.uno.modelo.CartaCoringa;
import lmv.uno.modelo.CartaComum;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    private CardDatabaseHelper dbHelper;

    public ArrayList<Carta> cartas = new ArrayList<>();

    private Map<Integer, Integer> cartasAzul = new HashMap<>();
    private Map<Integer, Integer> cartasVermelho = new HashMap<>();
    private Map<Integer, Integer> cartasVerde = new HashMap<>();
    private Map<Integer, Integer> cartasAmarelo = new HashMap<>();

    private Button buttonPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        dbHelper = new CardDatabaseHelper(this);

        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            // Callback que determina quando terminou de ser carregada a
            // WebView, para trocarmos a imagem de carregamento por ela
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        webView.loadUrl("file:///android_asset/index.html");

        if (cartasAzul.size() == 0)
            adicionarCartas();
    }

    // Interface para binding Javascript -> Java
    public class WebAppInterface {
        private MainActivity mainActivity;

        public WebAppInterface(MainActivity activity) {
            this.mainActivity = activity;
        }

        @JavascriptInterface
        public String getImageName(int resourceId) {
            return ImageNameMapper.getImageName(mainActivity, resourceId);
        }

        @JavascriptInterface
        public void resetIsSorted() {
            dbHelper.resetIsSorted();
        }

        @JavascriptInterface
        public String getAllSortedCards() {
            List<String> sortedCardImageNames = dbHelper.getAllSortedCardImageNames(mainActivity);

            Gson gson = new Gson();
            String jsonSortedCards = gson.toJson(sortedCardImageNames);

            return jsonSortedCards;
        }

        @JavascriptInterface
        public void changeCard() {
            int newImageResourceId = mainActivity.obterCarta().getImagemCarta();
            String imageName = getImageName(newImageResourceId);

            Log.d("ImageName", "Image Name: " + imageName);

            mainActivity.runJavaScript("setImageResourceId('" + imageName + "');");
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void runJavaScript(final String jsCode) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webView.evaluateJavascript(jsCode, null);
            }
        });
    }

    private void adicionarCartas() {
        adicionarCartasAzul();
        adicionarCartasVermelha();
        adicionarCartasVerde();
        adicionarCartasAmarelo();
    }

    private void adicionarCartasAmarelo() {
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow0);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow1);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow2);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow3);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow4);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow5);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow6);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow7);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow8);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellow9);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellowdraw2);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellowreverse);
        dbHelper.addCard(Carta.COR_AMARELO, R.drawable.uno_card_yellowskip);
    }

    private void adicionarCartasVerde() {
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green0);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green1);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green2);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green3);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green4);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green5);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green6);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green7);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green8);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_green9);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_greendraw2);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_greenreverse);
        dbHelper.addCard(Carta.COR_VERDE, R.drawable.uno_card_greenskip);
    }

    private void adicionarCartasVermelha() {
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red0);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red1);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red2);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red3);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red4);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red5);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red6);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red7);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red8);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_red9);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_reddraw2);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_redreverse);
        dbHelper.addCard(Carta.COR_VERMELHO, R.drawable.uno_card_redskip);
    }

    private void adicionarCartasAzul() {
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue0);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue1);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue2);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue3);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue4);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue5);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue6);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue7);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue8);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blue9);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_bluedraw2);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_bluereverse);
        dbHelper.addCard(Carta.COR_AZUL, R.drawable.uno_card_blueskip);
    }

    private void buttonPopupMenu_onClick(View view) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, buttonPopupMenu);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                listarCartas();
                return false;
            }
        });
        popupMenu.show();
    }

    public void listarCartas(){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("list", cartas);
        startActivity(intent);
    }

    public Carta obterCarta() {
        Carta carta;
        int contador = 0;

        while (true) {
            Long idCarta = obterNumeroAleatorio(52l);
            carta = dbHelper.getCardById(idCarta);
            dbHelper.markCardAsSorted(idCarta);

            if (carta != null)
                break;

            if (contador == 10) {
                Toast.makeText(this, "Todas as cartas sorteadas", Toast.LENGTH_LONG).show();
                break;
            }

            contador++;
        }

        return carta;
    }

    public void alterarCor(int cor){
        webView.setBackgroundColor(cor);
    }

    private Long obterNumeroAleatorio(Long quantidadeCarta) {
        return ThreadLocalRandom.current().nextLong(53);
    }
}


