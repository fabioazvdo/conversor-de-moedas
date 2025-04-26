package modelos;

import java.io.IOException;
import java.util.Scanner;

public class MenuDeIteracao extends DadosConversor {
    private boolean saidaDoLoop = false;
    private Scanner entrada = new Scanner(System.in);
    private final String menu =
            """
                    ╔═══════════════════════════════════════════════════════╗
                    ║                 *******************                   ║
                    ║**************** Conversor de Moedas ******************║
                    ║                 *******************                   ║
                    ╠═══════════════════════════════════════════════════════╣
                    ║ 1) Dólar -> Real brasileiro                           ║
                    ║ 2) Real brasileiro -> Dólar                           ║
                    ║ 3) Dólar -> Peso argentino                            ║
                    ║ 4) Peso argentino -> Dólar                            ║
                    ║ 5) Dólar -> Euro                                      ║
                    ║ 6) Euro -> Dólar                                      ║
                    ║ 7) Visualizar e salvar histórico                      ║
                    ║ 8) Sair                                               ║
                    ╚═══════════════════════════════════════════════════════╝
                    """;

    public void menuInicial() throws IOException, InterruptedException {
        System.out.println(menu);
        System.out.println("Escolha uma opção:");
        String opcaoMenu = entrada.nextLine();

        if (!opcaoMenu.matches("\\d+")) { // Verifica se a entrada contém apenas números
            System.out.println("Opção inválida! Por favor, insira um número entre 1 e 8.");
            return;
        }

        switch (opcaoMenu) {
            case "1":
                setMoedaRequisito("USD");
                setMoedaResposta("BRL");
                solicitarDados();
                break;
            case "2":
                setMoedaRequisito("BRL");
                setMoedaResposta("USD");
                solicitarDados();
                break;
            case "3":
                setMoedaRequisito("USD");
                setMoedaResposta("ARS");
                solicitarDados();
                break;
            case "4":
                setMoedaRequisito("ARS");
                setMoedaResposta("USD");
                solicitarDados();
                break;
            case "5":
                setMoedaRequisito("USD");
                setMoedaResposta("EUR");
                solicitarDados();
                break;
            case "6":
                setMoedaRequisito("EUR");
                setMoedaResposta("USD");
                solicitarDados();
                break;
            case "7":
                System.out.println("Visualizando histórico...");
                break;
            case "8":
                System.out.println("Saindo...");
                saidaDoLoop = true;
                break;
            default:
                System.out.println("Opção inválida! Por favor, insira um número entre 1 e 8.");
                break;
        }
    }

    public boolean isSaidaDoLoop() {
        return saidaDoLoop;
    }

}
