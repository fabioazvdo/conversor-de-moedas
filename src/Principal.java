import modelos.Conversor;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor conversor = new Conversor();
        conversor.setMoedaRequisito("USD");
        conversor.setMoedaResposta("BRL");
        conversor.solicitarDados();

    }
}
