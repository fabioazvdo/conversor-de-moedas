package modelos;

import java.io.IOException;
import java.util.Scanner;

public class MenuDeIteracao {
    private final DadosConversor dadosConversor = new DadosConversor();
    private boolean saidaDoLoop = false;
    private final Scanner entrada = new Scanner(System.in);

    private void processarConversao(Moeda moedaRequisito, Moeda moedaResposta) throws IOException, InterruptedException {
        dadosConversor.setMoedaRequisito(moedaRequisito.name());
        dadosConversor.setMoedaResposta(moedaResposta.name());
        dadosConversor.solicitarDados();
    }

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

        if (!opcaoMenu.matches("\\d+") || Integer.parseInt(opcaoMenu) < 1 || Integer.parseInt(opcaoMenu) > 8) {
            System.out.println("Opção inválida! Por favor, insira um número entre 1 e 8.");
            return;
        }

        switch (opcaoMenu) {
            case "1" -> processarConversao(Moeda.USD, Moeda.BRL);
            case "2" -> processarConversao(Moeda.BRL, Moeda.USD);
            case "3" -> processarConversao(Moeda.USD, Moeda.ARS);
            case "4" -> processarConversao(Moeda.ARS, Moeda.USD);
            case "5" -> processarConversao(Moeda.USD, Moeda.EUR);
            case "6" -> processarConversao(Moeda.EUR, Moeda.USD);
            case "7" -> {
                System.out.println("Visualizando histórico...");
                System.out.println(dadosConversor.formatarHistorico());
                dadosConversor.novoArquivo();
            }
            case "8" -> {
                System.out.println("Saindo...");
                saidaDoLoop = true;
            }
        }
    }

    public boolean isSaidaDoLoop() {
        return saidaDoLoop;
    }
}