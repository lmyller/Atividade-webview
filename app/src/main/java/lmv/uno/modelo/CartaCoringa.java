package lmv.uno.modelo;

import android.graphics.Color;

public class CartaCoringa extends Carta {
    public static final int QUANTIDADE_CARTA_CORINGA = 2;
    public static final int MAIS_QUATRO = 4;
    public static final int ESCOLHER_COR = 0;

    private int tipoCarta;

    public CartaCoringa(int cor, int imagemCarta, int tipoCarta) {
        super(cor, imagemCarta);
        this.tipoCarta = tipoCarta;
    }
}
