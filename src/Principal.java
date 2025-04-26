
import modelos.MenuDeIteracao;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        MenuDeIteracao menu = new MenuDeIteracao();
        while (!menu.isSaidaDoLoop()) {
            menu.menuInicial();
        }

    }
}
