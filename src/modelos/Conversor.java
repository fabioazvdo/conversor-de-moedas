package modelos;

public class Conversor {
    private String nome;
    private String sigla;
    private double valor;

    public Conversor(String nome, String sigla, double valor) {
        this.nome = nome;
        this.sigla = sigla;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
