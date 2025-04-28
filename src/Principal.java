
import modelos.MenuDeIteracao;


public class Principal {
    public static void main(String[] args) {
        MenuDeIteracao menu = new MenuDeIteracao();
        while (!menu.isSaidaDoLoop()) {
            menu.menuInicial();
        }

    }
}
