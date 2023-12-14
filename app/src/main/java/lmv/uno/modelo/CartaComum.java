package lmv.uno.modelo;

public class CartaComum extends Carta {

    public static final int QUANTIDADE_CARTA_COMUM = 13;
    public static final int QUANTIDADE_CARTA_NUMERO = 10;
    public static final int MAIS_DOIS = 10;
    public static final int INVERSAO = 11;
    public static final int PULAR = 12;

    private int simbolo;

    public CartaComum(int cor, int imagemCarta, int simbolo) {
        super(cor, imagemCarta);
        this.simbolo = simbolo;
    }

    public int getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(int simbolo) {
        this.simbolo = simbolo;
    }
}