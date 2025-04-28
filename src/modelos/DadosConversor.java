package modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class DadosConversor {
    private final String apiKey = "SUA API KEY AQUI";
    private String moedaRequisito;
    private String moedaResposta;
    private final List<ConversorAPI> lista = new ArrayList<>();

    public void solicitarDados() {
        String url = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/pair/"
                + this.moedaRequisito + "/" + this.moedaResposta;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();
            ConversorAPI conversorAPI = gson.fromJson(response.body(), ConversorAPI.class);
            System.out.println("Moeda requisitada: " + this.moedaRequisito + "\nMoeda resposta: " + this.moedaResposta);
            System.out.println("Valor de conversão: " + conversorAPI.conversionRate());
            lista.add(conversorAPI);
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao solicitar dados: " + e.getMessage());
        }
    }

    public void setMoedaRequisito(String moedaRequisito) {
        this.moedaRequisito = moedaRequisito;
    }

    public void setMoedaResposta(String moedaResposta) {
        this.moedaResposta = moedaResposta;
    }

    public String formatarHistorico() {
        StringBuilder sb = new StringBuilder();
        sb.append("Histórico de Conversões:\n");
        for (int i = 0; i < lista.size(); i++) {
            ConversorAPI conversao = lista.get(i);
            sb.append(String.format("Conversão %d:\n", i + 1));
            sb.append(String.format("  Moeda Requisitada: %s\n", moedaRequisito));
            sb.append(String.format("  Moeda Resposta: %s\n", moedaResposta));
            sb.append(String.format("  Valor Convertido: %.2f\n", conversao.conversionRate()));
            sb.append("\n");
        }
        return sb.toString();
    }

    public void novoArquivo() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escritor = new FileWriter("historico.json")) {
            escritor.write(gson.toJson(lista));
            System.out.println("Histórico salvo no arquivo 'historico.json'.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o histórico no arquivo: " + e.getMessage());
        }
    }
}