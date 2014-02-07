package mod.desafio;

import java.util.Random;

public class Palavras {

    private String[] palavras = new String[] {"GATO", "BALEIA", "CACHORRO", "HIPOPOTAMO"};

    public Palavras() {
    }

    public String sorteio() {
        String palavraSorteada = palavras[(int)(random()*palavras.length)];

        return palavraSorteada;
    }

    public static double random() {
        Random r = new Random();

        return r.nextDouble();
    }
}
