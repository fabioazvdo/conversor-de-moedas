package modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private String moedaRequisito;
    private String moedaResposta;

    public void solicitarDados() throws IOException, InterruptedException {
        String apiKey = "SUA API KEY";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"
                + this.moedaRequisito + "/" + this.moedaResposta;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        ConversorAPI conversorAPI = gson.fromJson(json, ConversorAPI.class);
        System.out.println(conversorAPI.toString());
    }

    public void setMoedaRequisito(String moedaRequisito) {
        this.moedaRequisito = moedaRequisito;
    }

    public void setMoedaResposta(String moedaResposta) {
        this.moedaResposta = moedaResposta;
    }
}
