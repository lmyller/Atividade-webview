package lmv.uno.modelo;

import android.graphics.Color;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
abstract public class Carta implements Serializable{
    public static final int COR_AZUL = 0;
    public static final int COR_VERDE = 1;
    public static final int COR_AMARELO = 2;
    public static final int COR_VERMELHO = 3;
    public static final int COR_PRETO = 4;

    public static final int QUANTIDADE_CORES = 5;

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "cor")
    private int cor;
    @ColumnInfo(name = "imagem")
    private int imagemCarta;

    public Carta(int cor, int imagemCarta){
        setCor(cor);
        this.imagemCarta = imagemCarta;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getImagemCarta() {
        return imagemCarta;
    }
}
