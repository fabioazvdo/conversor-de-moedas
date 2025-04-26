package modelos;

import java.io.IOException;
import java.util.Scanner;

public class MenuDeIteracao extends DadosConversor {
    private boolean saidaDoLoop = false;
    private final Scanner entrada = new Scanner(System.in);


    private String menu() {
        return """
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
    }

    public void menuInicial() throws IOException, InterruptedException {
        System.out.println(menu());
        System.out.println("Escolha uma opção:");
        String opcaoMenu = entrada.nextLine();

        if (!opcaoMenu.matches("\\d+")) { // Verifica se a entrada contém apenas números
            System.out.println("Opção inválida! Por favor, insira um número entre 1 e 8.");
            return;
        }

        switch (opcaoMenu) {
            case "1" -> processarConversao("USD", "BRL");
            case "2" -> processarConversao("BRL", "USD");
            case "3" -> processarConversao("USD", "ARS");
            case "4" -> processarConversao("ARS", "USD");
            case "5" -> processarConversao("USD", "EUR");
            case "6" -> processarConversao("EUR", "USD");
            case "7" -> {
                System.out.println("Visualizando histórico...");
                System.out.println(getLista());
                novoArquivo();
            }
            case "8" -> {
                System.out.println("Saindo...");
                saidaDoLoop = true;
            }
            default -> System.out.println("Opção inválida! Por favor, insira um número entre 1 e 8.");
        }
    }

    private void processarConversao(String moedaRequisito, String moedaResposta) throws IOException, InterruptedException {
        setMoedaRequisito(moedaRequisito);
        setMoedaResposta(moedaResposta);
        solicitarDados();
    }

    public boolean isSaidaDoLoop() {
        return saidaDoLoop;
    }

}
